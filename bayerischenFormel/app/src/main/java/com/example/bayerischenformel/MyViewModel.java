package com.example.bayerischenformel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Double> number;

    public MutableLiveData<Double> getNumber() {
        if (number == null) {
            number = new MutableLiveData<Double>();
            number.setValue(0.0);
        }
        return number;
    }

    public void fth() {
        double x, y;
        x = number.getValue();
        y = 100 - (x - 1) / 3 * 40;
        number.setValue(y);
    }

    public void htf() {
        double x, y;
        x = number.getValue();
        y = 1 + (100 - x) / 40 * 3;
        number.setValue(y);
    }

    public void setNumber(double n) {
        number.setValue(n);
    }
}
