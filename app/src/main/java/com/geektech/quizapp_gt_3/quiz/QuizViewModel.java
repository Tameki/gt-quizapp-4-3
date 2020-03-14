package com.geektech.quizapp_gt_3.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_3.model.Question;
import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    public void init(int amount, Integer category, String difficulty) {
        isLoading.setValue(true);

        App.quizRepository.getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                isLoading.setValue(false);
                QuizViewModel.this.questions.setValue(questions);
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
//        Question question = questions.getValue().get(currentQuestionPosition.getValue());
//        question.setSelectedAnswerPosition(-1);

        currentQuestionPosition.setValue(currentQuestionPosition.getValue() + 1);
    }
}
