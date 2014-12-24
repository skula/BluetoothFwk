package com.skula.bluetoothfwk;

import com.skula.bluetoothfwk.services.BluetoothService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class RemoteActivity extends Activity {
	private BluetoothService btService;
	private EditText sendtext;
	private Button send;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Bundle bdl = getIntent().getExtras();
		String macAddress = bdl.getString("MAC_ADDRESS");
		btService = new BluetoothService(macAddress);
		
		btService.getDevice();
		btService.connect();
		
        sendtext = (EditText)findViewById(R.id.sendtxt);
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btService.sendData(sendtext.getText().toString());
			}
		});
	}
}