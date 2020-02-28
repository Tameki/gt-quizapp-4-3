package com.geektech.quizapp_gt_3;

import android.app.Application;
import android.util.Log;

import com.geektech.quizapp_gt_3.data.QuizRepository;
import com.geektech.quizapp_gt_3.data.local.QuizLocalDataSource;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;

public class App extends Application {

    public static QuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        quizRepository = new QuizRepository(
                new QuizLocalDataSource(),
                new QuizApiClient()
        );

        Log.d("ololo", "App create");
    }

}
