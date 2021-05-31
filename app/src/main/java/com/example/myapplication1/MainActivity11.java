package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity {

    private CountDownProgressBar cpb_countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        Button btn_start = findViewById(R.id.btn_start);
        Button btn_ownclock=findViewById(R.id.btn_ownclock);
        cpb_countdown = (CountDownProgressBar) findViewById(R.id.cpb_countdown);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpb_countdown.setDuration(10000, new CountDownProgressBar.OnFinishListener() {
                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity11.this, "完成了", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_ownclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity11.this, MainActivity8.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });
    }
}


