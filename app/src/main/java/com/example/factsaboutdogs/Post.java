package com.example.factsaboutdogs;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("body")
    private String text;

    public String getText() {
        return text;
    }
}
