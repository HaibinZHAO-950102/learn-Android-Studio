package com.example.bluetoothclass3;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.bluetooth.BluetoothDevice;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;


    public MutableLiveData<Integer> getNumber() {
        if(number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }
}
