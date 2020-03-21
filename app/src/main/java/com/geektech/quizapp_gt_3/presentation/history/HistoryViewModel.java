package com.geektech.quizapp_gt_3.presentation.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.model.History;
import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    MutableLiveData<List<History>> history = new MutableLiveData<>();
    LiveData<List<QuizResult>> quizResults = App.quizRepository.getQuizResults();

    public HistoryViewModel() {
        ArrayList<History> fakeHistory = new ArrayList<>();

        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));
        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));
        fakeHistory.add(new History(1, "", "", 12, 2, new Date()));

        history.setValue(fakeHistory);
    }
}
