package com.geektech.quizapp_gt_3.presentation.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_3.model.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    MutableLiveData<List<History>> history = new MutableLiveData<>();

    public HistoryViewModel() {
        ArrayList<History> fakeHistory = new ArrayList<>();

        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));
        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));
        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));

        history.setValue(fakeHistory);
    }
}
