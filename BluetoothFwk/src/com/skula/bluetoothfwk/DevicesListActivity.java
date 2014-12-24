package com.skula.bluetoothfwk;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.skula.bluetoothfwk.adapters.DeviceAdapter;

public class DevicesListActivity extends Activity {
	private ListView deviceList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deviceslistlayout);
		deviceList = (ListView) findViewById(R.id.devices_list);
		updateList();
		
		deviceList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
				BluetoothDevice item = (BluetoothDevice) deviceList.getItemAtPosition(position);
				String macAddress = item.getAddress();

				Intent intent = new Intent(v.getContext(), RemoteActivity.class);
				intent.putExtra("MAC_ADDRESS", macAddress);
				startActivity(intent);				
			}
		});
	}
	
	private void updateList(){
		Set<BluetoothDevice> setpairedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
		BluetoothDevice[] pairedDevices = (BluetoothDevice[]) setpairedDevices.toArray(new BluetoothDevice[setpairedDevices.size()]);
		DeviceAdapter adapter = new DeviceAdapter(this, R.layout.devicelayout, pairedDevices);
		deviceList.setAdapter(adapter);
	}
}