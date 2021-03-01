package com.example.bluetoothclass3;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BluetoothController {
    private BluetoothAdapter bluetoothAdapter;

    public BluetoothController() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void TurnOnBluetooth (Activity activity, int requestCode) {		// 打开蓝牙
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent, requestCode);
    }

    public void Visible(Context context) {
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        context.startActivity(discoverableIntent);
    }

    public void findDevice() {
        assert (bluetoothAdapter != null);
        bluetoothAdapter.startDiscovery();
    }

    public List<BluetoothDevice> getBondedDeviceList() {
        return new ArrayList<>(bluetoothAdapter.getBondedDevices());
    }




}
