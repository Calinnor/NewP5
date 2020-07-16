package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao
{
    /**read*/
    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    LiveData<List<Task>> getTasks_taskDao(long projectId);

    /**create*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTask_taskDao(Task task);

    /**update*/
    @Update
    int updateTask_taskDao(Task task);

    /**delete*/
    @Query("DELETE FROM Task WHERE id = :taskId")
    int deleteTask_taskDao(long taskId);
}
