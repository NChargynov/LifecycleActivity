package com.geeks.lifecycleactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("shamal", "SecondActivity onCreate");

        TextView textView = findViewById(R.id.text_view);

        String data = getIntent().getStringExtra("key1");
        textView.setText(data);

//        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                Log.d("shamal", "handleOnBackPressed");
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal", "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal", "SecondActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal", "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal", "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "SecondActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal", "SecondActivity onRestart");
    }
}