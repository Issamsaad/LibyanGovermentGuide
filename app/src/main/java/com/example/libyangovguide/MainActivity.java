package com.example.libyangovguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libyangovguide.Adapters.ClassifcationListAdapter;
import com.example.libyangovguide.Entities.Classification;
import com.example.libyangovguide.Services.ApiClient;
import com.example.libyangovguide.Services.ClassifcationService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private List<Classification> classifcations;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isOnline()) {
            startActivity(new Intent(MainActivity.this,NoInternetActivity.class));
            finishAffinity();
            System.exit(0);
        }
        listView = findViewById(R.id.listView);
        ClassifcationService classifcationService = ApiClient.getClient().create(ClassifcationService.class);
        Call call = classifcationService.findAll();
        call.enqueue(new Callback()
        {
            @Override
            public void onResponse(Call call, Response response) {
                classifcations = (List<Classification>) response.body();
                listView.setAdapter(new ClassifcationListAdapter(getApplicationContext(), classifcations));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                startActivity(new Intent(MainActivity.this,ProceduresActivity.class)
                           .putExtra("classifctionID",Integer.parseInt(view.getTag().toString())));


            }
        });

    }
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}










