package com.example.libyangovguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.libyangovguide.Adapters.ProcListAdapter;
import com.example.libyangovguide.Entities.Proc;
import com.example.libyangovguide.Services.ApiClient;
import com.example.libyangovguide.Services.ProcService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProceduresActivity extends AppCompatActivity {
    private ListView listView;
    private List<Proc> procs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        Intent myIntent = getIntent(); // gets the previously created intent
        int p_classifcationID = myIntent.getIntExtra("classifctionID",0);

        ProcService procService= ApiClient.getClient().create(ProcService.class);
        Call call = procService.getProcs(p_classifcationID);
        call.enqueue(new Callback()
        {
            @Override
            public void onResponse(Call call, Response response) {
                procs= (List<Proc>) response.body();
                listView.setAdapter(new ProcListAdapter(getApplicationContext(),procs));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(ProceduresActivity.this,DetailActivity.class)
                        .putExtra("procedureID",Integer.parseInt(view.getTag().toString())));
            }
        });

    }
}


