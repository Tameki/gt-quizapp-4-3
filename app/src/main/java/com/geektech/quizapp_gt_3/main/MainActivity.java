package com.geektech.quizapp_gt_3.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.geektech.quizapp_gt_3.R;

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












