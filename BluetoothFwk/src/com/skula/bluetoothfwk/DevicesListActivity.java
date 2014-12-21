package com.skula.bluetoothfwk;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
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
	}
	
	private void updateList(){
		Set<BluetoothDevice> setpairedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
		BluetoothDevice[] pairedDevices = (BluetoothDevice[]) setpairedDevices.toArray(new BluetoothDevice[setpairedDevices.size()]);
		DeviceAdapter adapter = new DeviceAdapter(this, R.layout.devicelayout, pairedDevices);
		deviceList.setAdapter(adapter);
	}
}