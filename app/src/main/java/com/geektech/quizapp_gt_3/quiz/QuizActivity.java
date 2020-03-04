package com.geektech.quizapp_gt_3.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.geektech.quizapp_gt_3.R;

public class QuizActivity extends AppCompatActivity {

    private static final String EXTRA_AMOUNT = "amount";
    private static final String EXTRA_CATEGORY = "category";
    private static final String EXTRA_DIFFICULTY = "difficulty";

    public static void start(Context context, int amount, String category, String difficulty) {
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

        ViewModelProviders.of(this).get(QuizViewModel.class).init(
                10, 1, "easy"
        );
    }
}
