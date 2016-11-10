package com.example.user.todolistdemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private TaskAdapter tAdapter;
    SQLiteDatabase db;
    private TodoListSQLHelper todoListSQLHelper;
    public static ArrayList<TaskModel> taskModelList6 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        todoListSQLHelper = new TodoListSQLHelper(this.getApplicationContext());
        db = todoListSQLHelper.getWritableDatabase();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        taskModelList6=getTasksList();
        tAdapter = new TaskAdapter(taskModelList6);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItem(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tAdapter);
        tAdapter.notifyDataSetChanged();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                Intent intent=new Intent(this,DetailActivity.class);
                startActivity(intent);


        }
      return true;
    }



    public void show(View view)
    {
       // Toast.makeText(getBaseContext(),taskModelList.get(1).getTitle(),Toast.LENGTH_SHORT).show();
        db.execSQL("delete from "+ TodoListSQLHelper.TABLE_NAME1);
    }


    public static  ArrayList<TaskModel> getTasksList()
    {
       DetailActivity dt=new DetailActivity();
       ArrayList<TaskModel> list= dt.tasklist_method();
        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        taskModelList6=getTasksList();
        tAdapter = new TaskAdapter(taskModelList6);
    }

    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        taskModelList6=getTasksList();
        tAdapter = new TaskAdapter(taskModelList6);


        // Activity being restarted from stopped state
    }




}



