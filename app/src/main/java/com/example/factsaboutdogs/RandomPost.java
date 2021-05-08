package com.example.factsaboutdogs;

import com.google.gson.annotations.SerializedName;

public class RandomPost {

    @SerializedName("fact")
    private String text;

    public String getText() {
        return text;
    }

}
