package com.example.lifedatatest;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if(LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikedNumber(int n){
        LikedNumber.setValue(LikedNumber.getValue() + n);
    }

}
