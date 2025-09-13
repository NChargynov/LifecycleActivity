package com.geeks.lifecycleactivity;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ololo", "onCreate MainActivity");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imag_view);

        findViewById(R.id.btn_open).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
//            finish();
        });

        findViewById(R.id.btn_open_url).setOnClickListener(v -> {
           openUrl("https://www.youtube.com/watch?v=qwosU7e9mqc&list=RDqwosU7e9mqc&start_radio=1");
        });


        imageView.setOnClickListener(v -> {
            openGallery();
        });
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        intent.setData(uri);
        startActivity(intent);
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,  100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == MainActivity.RESULT_OK && data != null){
            //системный путь к фото
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ololo", "onPause MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo", "onStop MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ololo", "onRestart MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo", "onDestroy MainActivity");
    }
}