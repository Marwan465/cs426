package com.example.sec_lab;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button button;
    TextView name, desc;
    To_Do info;

    //ArrayList<Integer> DelItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        info = (To_Do) getIntent().getSerializableExtra("key");
        //DelItems = getIntent().getIntegerArrayListExtra("Del");
        button = findViewById(R.id.button);
        name = findViewById(R.id.textView2);
        desc = findViewById(R.id.textView3);
        name.setText(info.getName());
        desc.setText(info.getDesc());
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}