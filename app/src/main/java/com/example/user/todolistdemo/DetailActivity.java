package com.example.user.todolistdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    SQLiteDatabase db;
    private TodoListSQLHelper todoListSQLHelper;
    private static ArrayList<TaskModel> taskModelList6 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        todoListSQLHelper = new TodoListSQLHelper(this.getApplicationContext());
        db = todoListSQLHelper.getWritableDatabase();
        db = todoListSQLHelper.getReadableDatabase();



       // db = todoListSQLHelper.getReadableDatabase();
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar_child);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }


public void save(View v)
{
    todoListSQLHelper = new TodoListSQLHelper(DetailActivity.this);
    db = todoListSQLHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    EditText ed1 = (EditText) findViewById(R.id.editText);
    EditText ed2 = (EditText) findViewById(R.id.editText2);
    String title=ed1.getText().toString();
    String desc=ed2.getText().toString();
    values.put(TodoListSQLHelper.COL1_TITLE, title);
    values.put(TodoListSQLHelper.COL2_DETAIL, desc);
     long row=db.insertWithOnConflict(TodoListSQLHelper.TABLE_NAME1, null, values, SQLiteDatabase.CONFLICT_REPLACE);
     Toast.makeText(getBaseContext(),"saved"+row,Toast.LENGTH_SHORT).show();

      getAllData();

}


        public void getAllData() {

           db = todoListSQLHelper.getReadableDatabase();


        Cursor cursor = db.query(TodoListSQLHelper.TABLE_NAME1,
                new String[]{TodoListSQLHelper.COL1_TITLE, TodoListSQLHelper.COL2_DETAIL},
                null, null, null, null, null);

        cursor.moveToFirst();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                //create a new Games object and retrieve the data from the cursor to be stored in this Games object
                TaskModel taskModel = new TaskModel();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank Games object to contain our data

                taskModel.setTitle(cursor.getString(cursor.getColumnIndex(TodoListSQLHelper.COL1_TITLE)));
                taskModel.setDesc(cursor.getString(cursor.getColumnIndex(TodoListSQLHelper.COL2_DETAIL)));

                taskModelList6.add(taskModel);

            }while(cursor.moveToNext());
        }

    }


    public  static  ArrayList<TaskModel> tasklist_method()
    {

      return taskModelList6;
    }


}
