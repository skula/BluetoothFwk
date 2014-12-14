package com.skula.bluetoothfwk.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.skula.bluetoothfwk.R;
import com.skula.models.Device;

public class DeviceAdapter  extends ArrayAdapter<Device> {

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
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.devicelayout, parent, false);
		
		//TextView shortcut = (TextView) rowView.findViewById(R.id.episode_shortcut);
		//shortcut.setText(episode.getShortcut());	

		return rowView;
	}
}
