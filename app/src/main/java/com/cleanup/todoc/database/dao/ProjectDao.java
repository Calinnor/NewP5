package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

@Dao
public interface ProjectDao
{

    @Query("SELECT * FROM Project WHERE id = :projectId")
    LiveData<Project> getProject_projectDao(long projectId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createProject_projectDao(Project project);

}
