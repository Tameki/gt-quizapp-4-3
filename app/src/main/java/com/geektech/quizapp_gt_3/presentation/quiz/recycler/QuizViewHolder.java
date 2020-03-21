package com.geektech.quizapp_gt_3.presentation.quiz.recycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_3.model.EType;
import com.geektech.quizapp_gt_3.model.Question;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    private Listener listener;
    private ViewGroup multipleContainer;
    private TextView multipleAnswer1;
    private TextView multipleAnswer2;
    private TextView multipleAnswer3;
    private TextView multipleAnswer4;

    private ViewGroup booleanContainer;
    private TextView booleanAnswer1;
    private TextView booleanAnswer2;

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);

        listener.onAnswerClick(0);
        listener.onAnswerClick(1);
        listener.onAnswerClick(2);
        listener.onAnswerClick(3);

        listener.onAnswerClick(0);
        listener.onAnswerClick(1);
    }

    void onBind(Question question) {
        reset();

        if (question.getType() == EType.MULTIPLE) {
            //TODO: Show multiple container, hide boolean container
        } else {
            //TODO: Show boolean container, hide multiple container
        }

        setSelectedAnswer(question);
    }

    private void reset() {
        resetAnswerViews(
                multipleAnswer1,
                multipleAnswer2,
                multipleAnswer3,
                multipleAnswer4,
                booleanAnswer1,
                booleanAnswer2
        );
    }

    private void resetAnswerViews(TextView... textViews) {
        for (TextView textView : textViews) {
            //TODO: Reset text color, background and etc.
        }
    }

    private void setSelectedAnswer(Question question) {
        //TODO: Check for answer
    }

    interface Listener {
        void onAnswerClick(int selectedAnswerPosition);
    }
}
