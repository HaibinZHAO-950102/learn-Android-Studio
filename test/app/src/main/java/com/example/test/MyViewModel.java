package com.example.test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Random;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer>  a, b;
    public int c = 0, number = 0, d = 0;



    public MutableLiveData<Integer> getA() {
        if (a == null) {
            a = new MutableLiveData<>();
            a.setValue(0);
        }
        return a;
    }

    public MutableLiveData<Integer> getB() {
        if (b == null) {
            b = new MutableLiveData<>();
            b.setValue(0);
        }
        return b;
    }

    public void question() {
        Random random = new Random();
        int x, y;
        x = random.nextInt(10) + 1;
        y = random.nextInt(10) + 1;
        a.setValue(x);
        b.setValue(y);
        c = x + y;
    }

    public boolean check() {
        if (number == c)  {
            return true;
        }
        else {
            return false;
        }
    }

    public void setNumber(int n) {
        number = n;
    }

}
