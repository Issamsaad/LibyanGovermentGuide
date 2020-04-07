package com.example.libyangovguide;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;

public class NoInternetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        Handler handler = new Handler();

       handler.postDelayed(new Runnable() {
            public void run() {
                finish();



            }
        }, 3000);
    }

}
