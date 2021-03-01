package com.example.bluetoothclass3;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import java.util.List;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

public class DeviceAdapter extends BaseAdapter {
    private List<BluetoothDevice> bluetoothDeviceList;
    private Context context;

    public DeviceAdapter(List<BluetoothDevice> data, Context c) {
        bluetoothDeviceList = data;
        context = c.getApplicationContext();
    }

    @Override
    public int getCount() {
        return bluetoothDeviceList.size();
    }

    @Override
    public Object getItem(int position) {
        return bluetoothDeviceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_2, parent, false);
        }
        TextView line1 = (TextView) view.findViewById(android.R.id.text1);
        TextView line2 = (TextView) view.findViewById(android.R.id.text2);

        //获取对应的蓝牙设备
        BluetoothDevice device = (BluetoothDevice) getItem(position);

        //显示名称
        line1.setText(device.getName());
        //显示地址
        line2.setText(device.getAddress());

        return view;
    }

    public void refresh(List<BluetoothDevice> data) {
        bluetoothDeviceList = data;
        notifyDataSetChanged();
    }
}
