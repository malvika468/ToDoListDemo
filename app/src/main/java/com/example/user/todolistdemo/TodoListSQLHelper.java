package com.example.user.todolistdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class TodoListSQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "com.javapapers.androidtodo";
    public static final String TABLE_NAME1 = "TODO_LIST1";
    public static final String COL1_TITLE = "title";
    public static final String COL2_DETAIL = "detail";

    //public static final String COL1_TITLE = BaseColumns._ID;

    public TodoListSQLHelper(Context context) {
        //1 is todo list database version
        super(context, DB_NAME, null, 2);

    }
    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        //String createTodoListTable = "CREATE TABLE " + TABLE_NAME + " ( COL1_TITLE   PRIMARY KEY, " +
                //COL2_DETAIL + " TEXT )";

        String createTodoListTable="CREATE TABLE "+ TABLE_NAME1 + "(" + COL1_TITLE + " TEXT PRIMARY KEY, " +
                COL2_DETAIL + " TEXT NOT NULL )";

        sqlDB.execSQL(createTodoListTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {


        sqlDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqlDB);
    }


}