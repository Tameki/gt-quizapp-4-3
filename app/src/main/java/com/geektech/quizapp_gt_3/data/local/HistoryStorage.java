package com.geektech.quizapp_gt_3.data.local;

import androidx.lifecycle.LiveData;

import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.List;

public class HistoryStorage {

    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }

    public int saveQuizResult(QuizResult quizResult) {
        return (int) mHistoryDao.insert(quizResult);
    }

    public LiveData<List<QuizResult>> getQuizResults() {
        return mHistoryDao.getAll();
    }

}
