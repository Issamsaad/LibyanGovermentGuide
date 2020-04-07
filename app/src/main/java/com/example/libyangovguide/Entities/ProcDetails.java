package com.example.libyangovguide.Entities;

import com.google.gson.annotations.SerializedName;

public class ProcDetails {

    public String getTitle() {
        return Title;
    }

    @SerializedName("Title")
    private String  Title;
}
