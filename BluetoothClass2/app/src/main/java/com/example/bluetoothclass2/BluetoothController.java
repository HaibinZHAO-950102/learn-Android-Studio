package com.example.bluetoothclass2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class BluetoothController {
    private BluetoothAdapter bluetoothAdapter;

    public BluetoothController() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean isSupportBlueTooth() {
        if (bluetoothAdapter != null) {
            return true;
        }
        else  {
            return false;
        }
    }

    public boolean getBluetoothStatus() {
        assert (bluetoothAdapter != null);
        return bluetoothAdapter.isEnabled();
    }

    public void TurnOnBluetooth (Activity activity, int requestCode) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent, requestCode);
    }

    public void turnOffBluetooth() {
        bluetoothAdapter.disable();
    }
}
