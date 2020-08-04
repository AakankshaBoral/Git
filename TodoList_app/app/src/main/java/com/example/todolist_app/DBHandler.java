package com.example.todolist_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "to_do_tasks";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String note;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TASK + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "tasks_db";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBHandler.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DBHandler.TABLE_NAME);
        onCreate(db);

    }

    public long insert_task(String task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.COLUMN_TASK,task);
        long id = db.insert(DBHandler.TABLE_NAME,null,values);
        db.close();
        return (id);
    }

    public int update_task(Task task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHandler.COLUMN_TASK,task.getTask());
        return  db.update(DBHandler.TABLE_NAME,contentValues,DBHandler.COLUMN_ID+"=?",new String[]{String.valueOf(task.getId())});

    }

    public void delete_task(Task task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DBHandler.TABLE_NAME,DBHandler.COLUMN_ID+"=?",new String[]{String.valueOf(task.getId())});
        db.close();
    }

    public Task get_task(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
        DBHandler.TABLE_NAME,
                new String[]{DBHandler.COLUMN_ID, DBHandler.COLUMN_TASK, DBHandler.COLUMN_TIMESTAMP},
                DBHandler.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
         Task new_task = new Task(
                cursor.getInt(cursor.getColumnIndex(DBHandler.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TASK)),
                cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return new_task;
    }

    public List<Task> getAllNotes() {
        List<Task> tasks = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBHandler.TABLE_NAME + " ORDER BY " +
                DBHandler.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setId(cursor.getInt(cursor.getColumnIndex(DBHandler.COLUMN_ID)));
                task.setTask(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TASK)));
                task.setTimestamp(cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_TIMESTAMP)));

                tasks.add(task);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return tasks;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + DBHandler.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
}
