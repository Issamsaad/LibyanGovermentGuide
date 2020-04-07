package com.example.libyangovguide.Services;

import com.example.libyangovguide.Entities.Proc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProcService {
    @GET("LibyanGovWS/WS.asmx/GetActiveProcedure")
    Call<List<Proc>> getProcs(@Query("classification") int classification);
}
