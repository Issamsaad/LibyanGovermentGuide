package com.example.libyangovguide.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.libyangovguide.Entities.Classification;
import com.example.libyangovguide.R;

import java.util.List;

public class ClassifcationListAdapter extends ArrayAdapter<Classification>
{
    private Context context;
    private List<Classification> classifications;
    public  ClassifcationListAdapter( Context context,List<Classification> classifications) {
        super(context,R.layout.row_layout,classifications);
        this.context=context;
        this.classifications=classifications;


    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.row_layout, parent, false);
        Classification proc = classifications.get(position);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        textViewName.setText(proc.getClassificationName());

        convertView.setTag(proc.getClassifcationID());
        return  convertView;

    }

}
