package com.geektech.quizapp_gt_3.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geektech.quizapp_gt_3.model.QuizResult;

import java.util.List;

@Dao
public interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(QuizResult quizResult);

    @Query("SELECT * FROM quiz_result WHERE id=:id")
    QuizResult get(int id);

    @Delete
    void delete(QuizResult quizResult);

    //TODO: Write delete all query
//    void deleteAll();

    @Query("SELECT * FROM quiz_result")
    LiveData<List<QuizResult>> getAll();
}
