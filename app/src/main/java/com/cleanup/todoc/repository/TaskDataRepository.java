package com.cleanup.todoc.repository;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {

    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**crud from TaskDao
     *
     * Create = create task
     */
    public void createTask_taskDataRepository(Task task) { taskDao.insertTask_taskDao(task);}

    /**Read = get tasks*/
    public LiveData<List<Task>> getTasks_taskDataRepository(long projectId) {return this.taskDao.getTasks_taskDao(projectId);}

    /**Update = update task*/
    public void updateTask_taskDataRepository(Task task) { taskDao.updateTask_taskDao(task);}

    /**Delete = delete task*/
    public void deleteTask_taskDataRepository(long taskId) {taskDao.deleteTask_taskDao(taskId);}

}
