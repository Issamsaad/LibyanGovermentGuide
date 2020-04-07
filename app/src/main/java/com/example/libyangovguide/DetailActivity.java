package com.example.libyangovguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.libyangovguide.Entities.Proc;
import com.example.libyangovguide.Entities.ProcDetails;
import com.example.libyangovguide.Services.ProcDetailsService;
import com.example.libyangovguide.Services.SingleProcService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /****************************************************/
        Intent myIntent = getIntent(); // gets the previously created intent
        int p_procID = myIntent.getIntExtra("procedureID",0);

        final TextView procedureName = findViewById(R.id.TV_ProcedureName);
        final TextView tv_ShowDetails= findViewById(R.id.TV_ShowDetails);

        final TextView tv_ShowProcNote= findViewById(R.id.TV_ShowProcNote);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mofp-portal.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProcDetailsService apiHolder  = retrofit.create(ProcDetailsService.class);
        Call<List<ProcDetails>> call =  apiHolder.getDetails(p_procID);

        call.enqueue(new Callback<List<ProcDetails>>() {
            @Override
            public void onResponse(Call<List<ProcDetails>> call, Response<List<ProcDetails>> response) {
                if (!response.isSuccessful()) {
                    tv_ShowDetails.setText("لا يوجد نتائج للبحث  ..!" );
                    return;
                }
                List<ProcDetails> details = response.body();
                int counter=1;
                for (ProcDetails post : details) {
                    String content = "";
                    //  content += "userId:" + post.getUserId() + "\n";
                    content +=(counter++)+ "-" + post.getTitle() + "\n";

                    tv_ShowDetails.append(content);
                }


            }

            @Override
            public void onFailure(Call<List<ProcDetails>> call, Throwable t) {
                tv_ShowDetails.setText((t.getMessage()));
            }
        });

/****************************************************/

        SingleProcService apiHolder2  = retrofit.create(SingleProcService.class);
        Call<List<Proc>> call2 =  apiHolder2.getProc(p_procID);

        call2.enqueue(new Callback<List<Proc>>() {
            @Override
            public void onResponse(Call<List<Proc>> call, Response<List<Proc>> response) {
                if (!response.isSuccessful()) {
                    tv_ShowProcNote.setText("لا يوجد   ..!" );
                    return;
                }
                List<Proc> details = response.body();

                for (Proc post : details) {
                    procedureName.setText(post.getProcedureName());
                    String content2 = "";

                    content2 += post.getNote() + "\n";

                    tv_ShowProcNote.append(content2);
                }


            }

            @Override
            public void onFailure(Call<List<Proc>> call, Throwable t) {
                tv_ShowProcNote.setText((t.getMessage()));
            }
        });
        /************************************************** */
    }
}
