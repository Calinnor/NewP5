package com.cleanup.todoc.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.ProjectDataRepository;
import com.cleanup.todoc.repository.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    /**repository and for "asyncTask" class var*/
    private final TaskDataRepository taskDataSource;
    private final ProjectDataRepository projectDataSource;
    private final Executor executor;

    /**project data*/
    @Nullable
    private LiveData<Project> currentProject;

    /**constructor*/
    public TaskViewModel(TaskDataRepository taskDataSource, ProjectDataRepository projectDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.projectDataSource = projectDataSource;
        this.executor = executor;
    }

    /**use for initialise ViewModel in activity*/
    public void init(long projectId) {
        if(this.currentProject !=null) {
            return;
        }
        currentProject = projectDataSource.getProject_projectDataRepository(projectId);
    }

    /**Data source for PROJECT obtains from ProjectDataRepository
     *
     * read projects
     */
    public LiveData<Project> getProject_taskViewModel(long projectId) {
        return this.currentProject;
    }

    /**Datas source for TASK(s) obtains from TaskDataRepository
     *
     *Create new task
     */
    public void createItem_taskViewModel(Task task) {
        executor.execute(()->{
            taskDataSource.createTask_taskDataRepository(task);
        });
    }

    /**Read tasks*/
    public LiveData<List<Task>> getTasks_taskViewModel(long projectId) {
        return taskDataSource.getTasks_taskDataRepository(projectId);
    }

    /**update task*/
    public void updateTask_taskViewModel(Task task) {
        executor.execute(()->{
            taskDataSource.updateTask_taskDataRepository(task);
        });
    }

    /**delete task from Id*/
    public void deleteTask_taskViewModel(long taskId) {
        executor.execute(()->{
            taskDataSource.deleteTask_taskDataRepository(taskId);
        });
    }
}
