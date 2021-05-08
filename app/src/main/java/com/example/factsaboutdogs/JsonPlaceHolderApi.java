package com.example.factsaboutdogs;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

     @GET("all")
    Call<List<Post>> getPosts();

}
