package com.example.factsaboutdogs;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("fact")
    private String text;

    public String getText() {
        return text;
    }
}
