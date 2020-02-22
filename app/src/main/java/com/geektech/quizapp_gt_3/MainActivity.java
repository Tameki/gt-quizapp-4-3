package com.geektech.quizapp_gt_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mCounterTV;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        mViewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mCounterTV.setText(integer.toString());
            }
        });
    }

    private void initView() {
        mCounterTV = findViewById(R.id.counter);

        findViewById(R.id.btn_increment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onIncrementClick();
            }
        });
    }
}
