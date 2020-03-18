package com.geektech.quizapp_gt_3.presentation.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.quizapp_gt_3.R;
import com.geektech.quizapp_gt_3.presentation.history.recycler.HistoryAdapter;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView mRecycler;
    private HistoryAdapter mAdapter;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new HistoryAdapter();

        mRecycler = view.findViewById(R.id.history_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false));
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this)
                .get(HistoryViewModel.class);

//        mViewModel.history.observe(this, histories -> mAdapter.update(histories));

        mViewModel.history.observe(this, mAdapter::update);
    }

}
