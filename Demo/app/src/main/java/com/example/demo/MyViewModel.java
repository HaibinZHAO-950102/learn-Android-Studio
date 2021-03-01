package com.example.demo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> scorea, scoreb, lasta, lastb;

    public MutableLiveData<Integer> getScorea() {
        if(scorea == null) {
            scorea = new MutableLiveData<>();
            scorea.setValue(0);
            lasta = new MutableLiveData<>();
            lasta.setValue(0);
        }
        return scorea;
    }

    public MutableLiveData<Integer> getScoreb() {
        if (scoreb == null) {
            scoreb = new MutableLiveData<>();
            scoreb.setValue(0);
            lastb = new MutableLiveData<>();
            lastb.setValue(0);
        }
        return scoreb;
    }

    public void getLast() {
        scorea.setValue(lasta.getValue());
        scoreb.setValue(lastb.getValue());
    }

    public void adda(int n) {
        lasta.setValue(scorea.getValue());
        lastb.setValue(scoreb.getValue());
        scorea.setValue(scorea.getValue() + n);
    }

    public void addb(int n) {
        lasta.setValue(scorea.getValue());
        lastb.setValue(scoreb.getValue());
        scoreb.setValue(scoreb.getValue() + n);
    }

    public void reset() {
        scorea.setValue(0);
        scoreb.setValue(0);
    }
}
