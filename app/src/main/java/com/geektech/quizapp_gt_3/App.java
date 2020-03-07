package com.geektech.quizapp_gt_3;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.geektech.quizapp_gt_3.data.QuizRepository;
import com.geektech.quizapp_gt_3.data.db.QuizDatabase;
import com.geektech.quizapp_gt_3.data.local.HistoryStorage;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;

public class App extends Application {

    private static QuizDatabase quizDatabase;
    public static QuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        quizDatabase = Room.databaseBuilder(
                this,
                QuizDatabase.class,
                "quiz"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        quizRepository = new QuizRepository(
                new HistoryStorage(quizDatabase.historyDao()),
                new QuizApiClient()
        );

        Log.d("ololo", "App create");
    }

}
