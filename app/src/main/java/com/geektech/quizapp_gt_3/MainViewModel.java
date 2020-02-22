package com.geektech.quizapp_gt_3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private int mCounter = 0;
    public MutableLiveData<Integer> counter = new MutableLiveData<>();

    void onIncrementClick() {
        mCounter += 2;
        counter.setValue(mCounter);
    }

}
