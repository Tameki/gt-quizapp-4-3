package com.geektech.quizapp_gt_3.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.geektech.quizapp_gt_3.R;
import com.geektech.quizapp_gt_3.quiz.QuizActivity;

import org.angmarch.views.NiceSpinner;

public class MainFragment extends Fragment {

    private SeekBar mQuestionsSeekbar;
    private NiceSpinner mCategorySpinner;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mQuestionsSeekbar.getProgress();
//        mCategorySpinner.getSelectedIndex();
//        mCategorySpinner.getSelectedItem();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
