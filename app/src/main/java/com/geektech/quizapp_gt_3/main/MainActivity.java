package com.geektech.quizapp_gt_3.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.geektech.quizapp_gt_3.App;
import com.geektech.quizapp_gt_3.R;
import com.geektech.quizapp_gt_3.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_3.data.remote.QuizApiClient;
import com.geektech.quizapp_gt_3.model.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        new QuizApiClient().getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                Log.d("ololo", "Size " + questions.size());
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("ololo", e.getMessage(), e);
            }
        });
    }

    private void initView() {
        mViewPager = findViewById(R.id.main_pager);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //TODO:
            }
        });
    }
}












