package com.example.onlyofmy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainText extends AppCompatActivity {
    TextView textView;
    Button button;
    // 新页面的回传

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.massage);
        textView=findViewById(R.id.textView18);
        button=findViewById(R.id.button2);
        Intent intent_massage=getIntent();
        Bundle bundle=intent_massage.getExtras();
        textView.setText(bundle.getString("name"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
