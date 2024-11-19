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

    public static String KEY_1 = "key1";

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
        Log.d("ololo", "onCreate SecondActivity");

        TextView textView = findViewById(R.id.text_view);
        String text = getIntent().getStringExtra(KEY_1);
        textView.setText(text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo", "onStart SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", "onResume SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ololo", "onPause SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo", "onStop SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ololo", "onRestart SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo", "onDestroy SecondActivity");
    }
}