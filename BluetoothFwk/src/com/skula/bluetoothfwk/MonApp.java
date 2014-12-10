package com.skula.bluetoothfwk;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MonApp extends Activity implements OnClickListener {
	private TextView logview;
	private EditText sendtext;
	private Button connect, send;

	private BtInterface bt = null;
    
	private long lastTime = 0;
	
	final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            String data = msg.getData().getString("receivedData");
            
            long t = System.currentTimeMillis();
            if(t-lastTime > 100) {// Pour �viter que les messages soit coup�s
                logview.append("\n");
				lastTime = System.currentTimeMillis();
			}
            logview.append(data);
        }
    };
    
    final Handler handlerStatus = new Handler() {
        public void handleMessage(Message msg) {
            int co = msg.arg1;
            if(co == 1) {
            	logview.append("Connected\n");
            } else if(co == 2) {
            	logview.append("Disconnected\n");
            }
        }
    };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bt = new BtInterface(handlerStatus, handler);
        
        logview = (TextView)findViewById(R.id.logview);
        sendtext = (EditText)findViewById(R.id.sendtxt);
        
        connect = (Button)findViewById(R.id.connect);
        connect.setOnClickListener(this);
        
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if(v == connect) {
			bt.connect();
		} else if(v == send) {
			bt.sendData(sendtext.getText().toString());
		}
	}
}