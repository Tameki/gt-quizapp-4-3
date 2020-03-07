package com.geektech.quizapp_gt_3.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geektech.quizapp_gt_3.data.local.HistoryDao;
import com.geektech.quizapp_gt_3.model.QuizResult;

@Database(
        entities = {QuizResult.class},
        version = 1,
        exportSchema = false
)
public abstract class QuizDatabase extends RoomDatabase {
    public abstract HistoryDao historyDao();
}
