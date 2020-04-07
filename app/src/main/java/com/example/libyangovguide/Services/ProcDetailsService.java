package com.example.libyangovguide.Services;

import com.example.libyangovguide.Entities.ProcDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProcDetailsService {
    @GET("LibyanGovWS/WS.asmx/GetProcedureDetails")
    Call<List<ProcDetails>> getDetails(@Query("procedureID") int procedureID);
}
