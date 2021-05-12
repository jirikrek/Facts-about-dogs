package com.example.factsaboutdogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class Popup extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_layout);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int wigth = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(wigth),(int)(height*.6));

        Intent intent = getIntent();
        String context = intent.getStringExtra("context");

        TextView textView = findViewById(R.id.textView);
        textView.setText(context);

    }
}
