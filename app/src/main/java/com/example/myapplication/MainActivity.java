package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<event_time> List = new ArrayList<>();
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("Create",localTime));

        list = findViewById(R.id.life_cycle);
        adapter = new ListAdapter(this,R.layout.custom_list_rowitem,List);
        list.setAdapter(adapter);


    }


    public void gotoexplicite(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Object",List);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

    public void gotoimplicite(View view) {

        String Logs = new String() ;
        for (event_time t : List){
            Logs += "{ "+t.getEvent()+" : "+t.getTime()+" } ";
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,Logs);
        intent.setType("text/plain");
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("onStart",localTime));
        adapter.notifyDataSetChanged();

        super.onStart();
    }

    @Override
    protected void onPause() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("onPause",localTime));
        adapter.notifyDataSetChanged();

        super.onPause();
    }

    @Override
    protected void onRestart() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("onRestart",localTime));
        adapter.notifyDataSetChanged();

        super.onRestart();
    }

    @Override
    protected void onResume() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("onResume",localTime));
        adapter.notifyDataSetChanged();

        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        String localTime = date.format(currentLocalTime);
        List.add(new event_time("onDestroy",localTime));
        adapter.notifyDataSetChanged();

        super.onDestroy();
    }
}