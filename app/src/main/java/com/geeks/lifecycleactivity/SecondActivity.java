package com.geeks.lifecycleactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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


        TextView textView = findViewById(R.id.text_view);

        String text = getIntent().getStringExtra("key1");
        textView.setText(text);

        Log.d("shamal", "onCreate SecondActivity");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal", "onStart SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal", "onResume SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal", "onStop SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal", "onPause SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal", "onRestart SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "onDestroy SecondActivity");
    }
}