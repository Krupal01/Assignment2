package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends ArrayAdapter<event_time> {
    List<event_time> items_list = new ArrayList<>();
    int custom_layout_id;

    public GridAdapter(@NonNull Context context, int resource, List<event_time> objects) {
        super(context, resource, objects);
        items_list = objects;
        custom_layout_id = resource;
    }

    @Override
    public int getCount() {
        return items_list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.custom_grid_view, null);
        }

        TextView textView1 = v.findViewById(R.id.tv1);
        TextView textView2 = v.findViewById(R.id.tv2);

        event_time item = items_list.get(position);

        textView1.setText(item.getEvent());
        textView2.setText(item.getTime());
        return v;
    }
}
