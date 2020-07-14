//package com.cleanup.todoc.database.dao;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Update;
//import android.database.Cursor;
//
//import com.cleanup.todoc.model.Task;
//
//import java.util.List;
//
//@Dao
//public interface TaskDao {
//
//    /**select all task*/
//    @Query("SELECT * FROM Task WHERE fkProjectId = :projectId")
//    LiveData<List<Task>> getTasks(long projectId);
//
//    /**select all task too ?*/
//    @Query("SELECT * FROM Task WHERE fkProjectId = :projectId")
//    Cursor getTasksWithCursor(long projectId);
//
//    /**add new task in bdd*/
//    @Insert
//    long insertTask(Task task);
//
//    /**update task in bdd*/
//    @Update
//    int updateTask(Task task);
//
//    /**delete a task in bdd from her id*/
//    @Query("DELETE FROM Task WHERE pkTaskId = :taskId")
//    int deleteTask(long taskId);
//}
package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao
{
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

}
