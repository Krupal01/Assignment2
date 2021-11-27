package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<event_time> {

    private int resourceLayout;
    private Context mContext;

    public ListAdapter(@NonNull Context context, int resource, List<event_time> object) {
        super(context, resource, object);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.custom_list_rowitem, null);
        }
        event_time text = getItem(position);


        if (text != null){
            TextView t1 = view.findViewById(R.id.tv_event);
            TextView t2 = view.findViewById(R.id.tv_time);
            t1.setText(text.getEvent());
            t2.setText(text.getTime());

        }
        return view;
    }

}
