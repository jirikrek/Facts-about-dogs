package com.example.factsaboutdogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog-facts-api.herokuapp.com/api/v1/resources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //getPosts();
        getRandomPost();
    }

    private void getPosts(){
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> all = response.body();

                for (Post post : all){
                    String content = "";
                    content += "Text: " + post.getText()+"\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    private void getRandomPost(){

        Call<List<RandomPost>> call = jsonPlaceHolderApi.getRandomPost(24);

        call.enqueue(new Callback<List<RandomPost>>() {
            @Override
            public void onResponse(Call<List<RandomPost>> call, Response<List<RandomPost>> response) {

                if(!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<RandomPost> index = response.body();

                for (RandomPost randomPost : index){
                    String content = "";
                    content += "Text: " + randomPost.getText()+"\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<RandomPost>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

}