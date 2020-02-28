package com.geektech.quizapp_gt_3.data;

import com.geektech.quizapp_gt_3.data.local.QuizLocalDataSource;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository(
            QuizLocalDataSource localDataSource,
            QuizApiClient remoteDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

}
