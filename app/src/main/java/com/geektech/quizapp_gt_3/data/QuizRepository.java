package com.geektech.quizapp_gt_3.data;

import com.geektech.quizapp_gt_3.data.local.HistoryStorage;
import com.geektech.quizapp_gt_3.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;
import com.geektech.quizapp_gt_3.model.Question;

import java.util.List;

public class QuizRepository {
    private HistoryStorage localDataSource;
    private QuizApiClient quizApiClient;

    public QuizRepository(
            HistoryStorage localDataSource,
            QuizApiClient quizApiClient
    ) {
        this.localDataSource = localDataSource;
        this.quizApiClient = quizApiClient;
    }

    private Question shuffleAnswers(Question question) {
        //TODO: Shuffle answers
        return question;
    }

    public void getQuestions(IQuizApiClient.QuestionsCallback callback) {
        quizApiClient.getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                for (int i = 0; i < questions.size(); i++) {
                    Question question = shuffleAnswers(questions.get(i));
                    questions.set(i, question);
                }

                callback.onSuccess(questions);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }
}
