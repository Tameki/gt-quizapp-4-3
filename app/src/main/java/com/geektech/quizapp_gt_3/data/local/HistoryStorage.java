package com.geektech.quizapp_gt_3.data.local;

import com.geektech.quizapp_gt_3.model.QuizResult;

public class HistoryStorage {

    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }

    void saveQuizResult(QuizResult quizResult) {
        mHistoryDao.insert(quizResult);
    }

}
