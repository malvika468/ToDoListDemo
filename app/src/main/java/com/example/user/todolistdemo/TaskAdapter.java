package com.example.user.todolistdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 11/2/2016.
 */
public class TaskAdapter  extends  RecyclerView.Adapter<TaskAdapter.MyViewHolder>   implements View.OnClickListener {

    private ArrayList<TaskModel> taskModelList6;
    private  Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            context = itemView.getContext();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i=getAdapterPosition();
                    int c= getItemCount();
                    Intent intent=new Intent(context,Description.class);
                    Bundle extras = new Bundle();
                    extras.putInt("pos",i);
                    extras.putInt("size",c);
                    intent.putExtras(extras);
                    context.startActivity(intent);
                }
            });

        }
    }


    public TaskAdapter(ArrayList<TaskModel> taskModelList6) {
        notifyDataSetChanged();
        this.taskModelList6=taskModelList6;

          int c= getItemCount();
          Log.e("key",Integer.toString(c));

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_row, parent, false);

        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       // notifyDataSetChanged();
        TaskModel taskModel = taskModelList6.get(position);
       // notifyDataSetChanged();
        holder.title.setText(taskModel.getTitle());

    }


    @Override
    public int getItemCount() {
        return taskModelList6.size();
    }


    @Override
    public void onClick(View v){


    }

}
