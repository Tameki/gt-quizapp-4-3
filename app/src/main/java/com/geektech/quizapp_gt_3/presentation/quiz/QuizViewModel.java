package com.geektech.quizapp_gt_3.presentation.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.core.SingleLiveEvent;
import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.data.QuizRepository;
import com.geektech.quizapp_gt_3.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_3.model.Question;
import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {

    private QuizRepository quizRepository = App.quizRepository;
    private ArrayList<Question> mQuestions = new ArrayList<>();

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> openResultEvent = new SingleLiveEvent<>();

    private Integer currentQuestionPosition() {
        return currentQuestionPosition.getValue();
    }

    public void init(int amount, Integer category, String difficulty) {
        isLoading.setValue(true);

        App.quizRepository.getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                isLoading.setValue(false);
                mQuestions.clear();
                mQuestions.addAll(questions);
                QuizViewModel.this.questions.setValue(mQuestions);
                currentQuestionPosition.setValue(0);
            }

            @Override
            public void onFailure(Exception e) {
                isLoading.setValue(false);
            }
        });
    }

    private void moveToQuestionOrFinish(int position) {
        if (position == mQuestions.size()) {
            finishQuiz();
        } else {
            currentQuestionPosition.setValue(position);
        }
    }

    private int getCorrectAnswersAmount() {
        int correctAnswers = 0;

        for (Question question : mQuestions) {
            //TODO: Get selected and match with correct
        }

        return correctAnswers;
    }

    private void finishQuiz() {
        QuizResult quizResult = new QuizResult(
                0,
                "",
                "",
                mQuestions,
                getCorrectAnswersAmount(),
                new Date()
        );

        int resultId = quizRepository.saveQuizResult(quizResult);

        Log.d("ololo", "Result saved: id - " + resultId);

        //TODO: Open result screen
        openResultEvent.setValue(resultId);
        finishEvent.call();
    }

    void onAnswerClick(int selectedAnswerPosition) {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition == null || mQuestions == null) {
            return;
        }

        Question question = mQuestions.get(currentPosition);

        if (question.getSelectedAnswerPosition() == null) {
            question.setSelectedAnswerPosition(selectedAnswerPosition);
            mQuestions.set(currentPosition, question);

            questions.setValue(mQuestions);
        }

        moveToQuestionOrFinish(currentPosition + 1);
    }

    void onBackPressed() {
        Integer currentPosition = currentQuestionPosition.getValue();

        if (currentPosition != null) {
            if (currentPosition == 0) {
                finishEvent.call();
            } else {
                currentQuestionPosition.setValue(currentPosition - 1);
            }
        }
    }

    void onSkipClick() {
        finishQuiz();
//        onAnswerClick(-1);
    }
}
