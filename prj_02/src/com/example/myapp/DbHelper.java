package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 13.10.2015.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static int DB_VERSION = 1;
    public static final String DB_NAME = "tasks.db";

    public Cursor getTasksCursor() {
        return getReadableDatabase().
                query(TasksTable.TABLE_NAME,
                        new String[]{TasksTable.COL_ID, TasksTable.COL_TASK},
               null,null,null,null,null,null);
    }



    public final static class TasksTable {
        private TasksTable() {
        }

        public static final String TABLE_NAME = "tasks";
        public static final String COL_ID = "_id";
        public static final String COL_TASK = "task";

    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TasksTable.TABLE_NAME + " (" +
                        TasksTable.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        TasksTable.COL_TASK + " TEXT NOT NULL" +
                        ");");
        ContentValues values= new ContentValues();
       // values.put(TasksTable.COL_ID, 1);
        values.put(TasksTable.COL_TASK,"task_one");
        db.insert(TasksTable.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
