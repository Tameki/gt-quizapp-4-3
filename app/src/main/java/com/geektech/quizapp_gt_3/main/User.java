package com.geektech.quizapp_gt_3.main;

import com.geektech.quizapp_gt_3.core.ChangeListener;

import java.util.ArrayList;

public class User {
    private String name;
    private NameChangeListener nameChangeListener;

    public User(String name) {
        this.name = name;
    }

    public User(String name, NameChangeListener listener) {
        this.name = name;
        this.nameChangeListener = listener;
    }

    public NameChangeListener getNameChangeListener() {
        return nameChangeListener;
    }

    public void setNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListener = nameChangeListener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        nameChangeListener.onChanged(name);
    }

    public interface NameChangeListener extends ChangeListener<String> {
    }
    public interface EmailChangeListener extends ChangeListener<String> {}
    public interface UserChangeListener extends ChangeListener<User> {
    }
}
