package com.cleanup.todoc.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

@Database(entities = {Project.class, Task.class}, version = 1, exportSchema = false)
public abstract class Todoc_masterRoomDatabase extends RoomDatabase {

    //singleton
    private static volatile Todoc_masterRoomDatabase INSTANCE;

    //Daos interface to use in Injection
    public abstract ProjectDao projectDao();
    public abstract TaskDao taskDao();


    //Todoc_masterRoomDatabase unique instance
    public static Todoc_masterRoomDatabase getInstance(Context context) {
        //if INSTANCE is null
        if(INSTANCE == null) {
            //synchronisation with a Todoc_masterRoomDatabase instance
            synchronized (Todoc_masterRoomDatabase.class) {
                //then if there is nothing
                if (INSTANCE==null) {
                    //on crée une data base
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Todoc_masterRoomDatabase.class, "MyTodoc_masterRoomDatabase").build();
                }
            }
        }
        //if INSTANCE != null !-> here INSTANCE cannot be null
        return INSTANCE;
    }

    /**
     * Returns a callback to add the projects in the database, like in the leçon
     * @return a callback to add the projects in the database
     */
    private static Callback prepopulateDatabase() {
        return new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 1L);
                contentValues.put("name", "Projet Tartampion");
                contentValues.put("color", 0xFFEADAD1);
                db.insert("Project", OnConflictStrategy.IGNORE, contentValues);

                contentValues.put("id", 2L);
                contentValues.put("name", "Projet Lucidia");
                contentValues.put("color", 0xFFB4CDBA);
                db.insert("Project", OnConflictStrategy.IGNORE, contentValues);

                contentValues.put("id", 3L);
                contentValues.put("name", "Projet Circus");
                contentValues.put("color", 0xFFA3CED2);
                db.insert("Project", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }
}
