package com.geeks.lifecycleactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("ololo", "onCreate MainActivity");

        findViewById(R.id.btn_open).setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
//            finish();
        });


        imageView = findViewById(R.id.image_view);

        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 100);
        });

        findViewById(R.id.btn_open_url).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("https://www.ts.kg/show/squid_game_dub");
            intent.setData(uri);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 100 && resultCode == RESULT_OK && intent != null){

            //путь к фото
            Uri uri = intent.getData();
            imageView.setImageURI(uri);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume MainActivity");
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