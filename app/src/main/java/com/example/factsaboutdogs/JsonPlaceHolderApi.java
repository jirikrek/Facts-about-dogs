package com.example.factsaboutdogs;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

     @GET("dogs/all")
    Call<List<Post>> getPosts();

    @GET("dogs")
    Call<List<RandomPost>> getRandomPost(@Query("index") int index);



}
