package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<event_time> object = (ArrayList<event_time>) args.getSerializable("Object");

//        ArrayList<event_time> object = new ArrayList<>();
//        object.add(new event_time("dddd","ddddd"));
        GridView gridView = findViewById(R.id.grid_view);
        GridAdapter adapter = new GridAdapter(this,R.layout.custom_grid_view,object);
        gridView.setAdapter(adapter);



    }
}