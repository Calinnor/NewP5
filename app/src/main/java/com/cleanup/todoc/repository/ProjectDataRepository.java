package com.cleanup.todoc.repository;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

public class ProjectDataRepository {

    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    /**read project from ProjectDao*/
    public LiveData<Project> getProject_projectDataRepository(long projectId) {return this.projectDao.getProject_projectDao(projectId);}
}
