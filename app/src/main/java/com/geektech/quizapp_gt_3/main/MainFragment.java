package com.geektech.quizapp_gt_3.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.quizapp_gt_3.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModelActivity;
    private MainViewModel mViewModelFragment;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModelActivity = ViewModelProviders
                .of(getActivity())
                .get(MainViewModel.class);

        mViewModelFragment = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        mViewModelActivity.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });
    }

}
