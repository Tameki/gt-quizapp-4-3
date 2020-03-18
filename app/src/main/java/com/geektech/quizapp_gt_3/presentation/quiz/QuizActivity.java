package com.geektech.quizapp_gt_3.presentation.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.geektech.quizapp_gt_3.R;
import com.geektech.quizapp_gt_3.model.Question;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private static final String EXTRA_AMOUNT = "amount";
    private static final String EXTRA_CATEGORY = "category";
    private static final String EXTRA_DIFFICULTY = "difficulty";

    private QuizViewModel viewModel;

    public static void start(Context context, int amount, Integer category, String difficulty) {
        Intent intent = new Intent(context, QuizActivity.class);

        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_CATEGORY, category);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        viewModel = ViewModelProviders.of(this)
                .get(QuizViewModel.class);

        viewModel.questions.observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                //TODO: Set adapter data, adapter.setQuestions()
            }
        });

        viewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) {
                    //TODO: Hide views and show loading
                } else {
                    //TODO: Show views
                }
            }
        });

        viewModel.init(
                10, 1, "easy"
        );
    }
}









