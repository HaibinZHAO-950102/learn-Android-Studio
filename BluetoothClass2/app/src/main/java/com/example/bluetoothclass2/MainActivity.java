package com.example.bluetoothclass2;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bluetoothclass2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private BluetoothController bluetoothController = new BluetoothController();
    private Toast toast;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    TOAST("STATE_OFF");
                    break;
                case BluetoothAdapter.STATE_ON:
                    TOAST("STATE_ON");
                    break;
                case
                    BluetoothAdapter.STATE_TURNING_ON:
                    TOAST("STATE_TURNING_ON");
                    break;
                case
                    BluetoothAdapter.STATE_TURNING_OFF:
                    TOAST("STATE_TURNING_OFF");
                    break;
                default:
                    TOAST("UNKNOWN_STATE");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void isSupportBluetooth(View v) {
        boolean ret = bluetoothController.isSupportBlueTooth();
        TOAST("support Bluetooth!" + ret);
    }

    public void isBluetoothEnable(View v) {
        boolean ret = bluetoothController.getBluetoothStatus();
        TOAST("Enable Bluetooth!" + ret);
    }

    public void requestTurnOnBluetooth(View v) {
        bluetoothController.TurnOnBluetooth(this, 0);
    }

    public void TurnOffBluetooth(View v) {
        bluetoothController.turnOffBluetooth();
    }

    private void TOAST (String s) {
        if (toast == null) {
            toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        }
        else {
            toast.setText(s);
        }
        toast.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        MyViewModel myViewModel;
        ActivityMainBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ret = bluetoothController.isSupportBlueTooth();
                TOAST("support Bluetooth!" + ret);
            }
        });
    }
}