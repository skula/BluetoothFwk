package com.skula.bluetoothfwk.adapters;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.skula.bluetoothfwk.R;

public class DeviceAdapter extends ArrayAdapter<BluetoothDevice> {

	Context context;
	int layoutResourceId;
	BluetoothDevice data[] = null;

	public DeviceAdapter(Context context, int layoutResourceId, BluetoothDevice[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BluetoothDevice device = data[position];
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.devicelayout, parent, false);

		TextView name = (TextView) rowView.findViewById(R.id.device_name);
		name.setText(device.getName());
		TextView mac = (TextView) rowView.findViewById(R.id.device_mac);
		mac.setText(device.getAddress());
		ImageView connected = (ImageView) rowView.findViewById(R.id.device_connected);
		if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
			connected.setImageResource(R.drawable.on);
		} else {
			connected.setImageResource(R.drawable.off);
		}
		return rowView;
	}
}
