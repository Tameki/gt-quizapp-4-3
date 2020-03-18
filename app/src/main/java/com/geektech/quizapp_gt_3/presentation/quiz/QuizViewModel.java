package com.geektech.quizapp_gt_3.presentation.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_3.model.Question;
import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {

    private ArrayList<Question> mQuestions = new ArrayList<>();

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

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

    void onFinishQuiz() {
        QuizResult quizResult = new QuizResult(
                0,
                "",
                "",
                questions.getValue(),
                1,
                new Date()
        );
    }

    void onBackPress() {

    }

    void onAnswerClick(int selectedAnswerPosition) {

    }

    void onSkipClick() {
        Question question = mQuestions.get(currentQuestionPosition());
        question.setSelectedAnswerPosition(-1);
        mQuestions.set(currentQuestionPosition(), question);

        questions.setValue(mQuestions);

        currentQuestionPosition.setValue(currentQuestionPosition.getValue() + 1);
    }
}
