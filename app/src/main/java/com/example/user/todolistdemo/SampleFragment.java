package com.example.user.todolistdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 11/3/2016.
 */
public class SampleFragment  extends android.support.v4.app.Fragment {


    public SampleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container,
                false);
        TextView t = (TextView) rootView.findViewById(R.id.textView);
        Bundle args = getArguments();
        String desc = args.getString("index");
       // String desc= MainActivity.taskModelList6.get(index).getDesc();
        t.setText(desc);
        return rootView;
    }

}
