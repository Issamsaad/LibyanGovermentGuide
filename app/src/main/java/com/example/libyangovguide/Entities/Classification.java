package com.example.libyangovguide.Entities;

import com.google.gson.annotations.SerializedName;

public class Classification {
    @SerializedName("ClassifcationID")
    private int ClassifcationID;

    public int getClassifcationID() {
        return ClassifcationID;
    }

    public String getClassificationName() {
        return ClassificationName;
    }

    public boolean isActivityStatus() {
        return ActivityStatus;
    }
    @SerializedName("ClassificationName")
    private  String ClassificationName;
    @SerializedName("ActivityStatus")
    private boolean ActivityStatus;
}
