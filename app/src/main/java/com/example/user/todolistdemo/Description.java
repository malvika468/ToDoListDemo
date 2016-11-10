package com.example.user.todolistdemo;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Description extends AppCompatActivity {

    ViewPager mViewPager;
    static int pos;
    static int size;
   private static ArrayList<TaskModel> list=MainActivity.taskModelList6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mViewPager = (ViewPager) findViewById(R.id.pager);
/** set the adapter for ViewPager */
        mViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager(),list ));
        // mViewPager.setOnPageChangeListener(new MyPageChangeListener());
        mViewPager.setCurrentItem(pos);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        pos = extras.getInt("pos", -1);
        //String p = Integer.toString(pos);
        size = extras.getInt("size", 0);
        //        Toast.makeText(getBaseContext(), size, Toast.LENGTH_SHORT).show();
        Log.e("SIZE", Integer.toString(size));
    }


    public class SamplePagerAdapter extends FragmentPagerAdapter {

       private  ArrayList<TaskModel> list;

        public SamplePagerAdapter(FragmentManager fm, ArrayList<TaskModel> list ) {
            super(fm);
            this.list=list;


        }


        @Override
        public Fragment getItem(int position) {

             mViewPager.setCurrentItem(pos);
                SampleFragment  f = new SampleFragment();
                // Supply index input as an argument.
                Bundle args = new Bundle();
                args.putString("index", list.get(position).getDesc());
                f.setArguments(args);
                return  f;





        }


        @Override
        public int getCount() {

           // notifyDataSetChanged();
            return list.size();
        }
    }   }



