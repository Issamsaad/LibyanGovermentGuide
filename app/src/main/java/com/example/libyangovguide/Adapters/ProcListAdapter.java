package com.example.libyangovguide.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;


import com.example.libyangovguide.Entities.Proc;
import com.example.libyangovguide.R;

import java.util.List;

public class ProcListAdapter extends ArrayAdapter<Proc>
{
    private Context context;
    private List<Proc> procs;
    public  ProcListAdapter( Context context,List<Proc> procs) {
        super(context, R.layout.row_layout,procs);
        this.context=context;
        this.procs=procs;


    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.row_layout, parent, false);
        Proc proc = procs.get(position);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        textViewName.setText(proc.getProcedureName());

        convertView.setTag(proc.getProcedureID());
        return  convertView;

    }

}
