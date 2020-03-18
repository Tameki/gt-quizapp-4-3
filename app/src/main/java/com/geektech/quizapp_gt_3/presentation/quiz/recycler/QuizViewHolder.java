package com.geektech.quizapp_gt_3.presentation.quiz.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuizViewHolder extends RecyclerView.ViewHolder {
    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    interface Listener {
        void onAnswerClick(int selectedAnswerPosition);
    }
}
