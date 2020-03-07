package com.geektech.quizapp_gt_3.data;

import com.geektech.quizapp_gt_3.data.local.HistoryStorage;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;

public class QuizRepository {
    private HistoryStorage localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository(
            HistoryStorage localDataSource,
            QuizApiClient remoteDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

}
