package com.skula.bluetoothfwk.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.skula.bluetoothfwk.R;
import com.skula.models.Device;

public class DeviceAdapter extends ArrayAdapter<Device> {

	Context context;
	int layoutResourceId;
	Device data[] = null;

	public DeviceAdapter(Context context, int layoutResourceId, Device[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Device device = data[position];
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.devicelayout, parent, false);

		TextView name = (TextView) rowView.findViewById(R.id.device_name);
		name.setText(device.getName());
		TextView mac = (TextView) rowView.findViewById(R.id.device_mac);
		mac.setText(device.getMac());
		TextView connected = (TextView) rowView
				.findViewById(R.id.device_connected);
		if (device.isConnected()) {
			connected.setText("ON");
		} else {
			connected.setText("OFF");
		}
		return rowView;
	}
}
