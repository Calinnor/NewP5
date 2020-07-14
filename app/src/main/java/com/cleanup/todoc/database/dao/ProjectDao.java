//package com.cleanup.todoc.database.dao;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import com.cleanup.todoc.model.Project;
//
//@Dao
//public interface ProjectDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE/*REPLACE*/)//ignore write a new project ?
//    void createProject(Project project);
//
//    @Query("SELECT * FROM Project WHERE pkProjectId = :projectId")
//    LiveData<Project> getProject(long projectId);
//}
package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public interface ProjectDao
{

    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getAllProjects();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProject(Project project);

}
