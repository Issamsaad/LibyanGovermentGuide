package com.example.libyangovguide.Entities;
import com.google.gson.annotations.SerializedName;
public class Proc {
    @SerializedName("ProcedureID")
    private int ProcedureID ;

    @SerializedName("ProcedureName")
    private String  ProcedureName;

    @SerializedName("LastUpdate")
   private String  LastUpdate;

    @SerializedName("Note")
    private String  Note;

    public int getProcedureID()
    {
        return ProcedureID;
    }

    public String getProcedureName()
    {
        return ProcedureName;
    }
    public String getLastUpdate() {
        return LastUpdate;
    }
    public String getNote() {
        return Note;
    }
}
