package com.geektech.quizapp_gt_3.data;

import com.geektech.quizapp_gt_3.data.local.QuizLocalDataSource;
import com.geektech.quizapp_gt_3.data.remote.QuizRemoteDataSource;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizRemoteDataSource remoteDataSource;

    public QuizRepository(
            QuizLocalDataSource localDataSource,
            QuizRemoteDataSource remoteDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

}
