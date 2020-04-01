package com.geektech.quizapp_gt_3.presentation.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.model.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    LiveData<List<History>> history = App.quizRepository.getHistory();
}
