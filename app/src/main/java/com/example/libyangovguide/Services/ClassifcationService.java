package com.example.libyangovguide.Services;

import com.example.libyangovguide.Entities.Classification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ClassifcationService {
    @GET("LibyanGovWS/WS.asmx/GetActiveClassifcations")
    Call<List<Classification>> findAll();
}
