package com.geeks.lifecycleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


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

        EditText editText = findViewById(R.id.edit_text);

        findViewById(R.id.btn_open_second).setOnClickListener(view -> {
            // обработка клика

            String text = editText.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("key1", text);
            startActivity(intent);
//            finish();
        });
        Log.d("shamal", "onCreate MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal", "onStart MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal", "onResume MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal", "onStop MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal", "onPause MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal", "onRestart MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "onDestroy MainActivity");
    }
}