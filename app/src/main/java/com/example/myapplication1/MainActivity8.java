package com.example.myapplication1;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity8 extends AppCompatActivity  implements View.OnClickListener{

    private EditText inputet;
    private Button get, startTime, stopTime;
    private TextView time;
    private int i = 0;
    private Timer timer = null;
    private TimerTask task = null;

    private Paint arcPaint;  //圆弧画笔
    private Paint textPaint;  //时间文本画笔
    private int backgroundColor = Color.parseColor("#D1D1D1");
    private int arcColor = Color.BLUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        initView();
        Button stoptime=findViewById(R.id.stoptime);


    }
    private void initView() {
        inputet = findViewById(R.id.input);
        get = findViewById(R.id.get);
        startTime = findViewById(R.id.starttime);
        stopTime = findViewById(R.id.stoptime);
        time = findViewById(R.id.time);
        get.setOnClickListener(this);
        startTime.setOnClickListener(this);
        stopTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get:
                time.setText(inputet.getText().toString());
                i = 60*(Integer.parseInt(inputet.getText().toString()));
                break;
            case R.id.starttime:
                startTime();
                break;
            case R.id.stoptime:
                stopTime();
                break;
            default:
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            time.setText(msg.arg1 + "");
            startTime();
        };
    };


    //倒计时主要核心
    public void startTime() {
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                if (i > 0) {   //加入判断不能小于0
                    i--;
                    Message message = mHandler.obtainMessage();
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                }
            }
        };
        timer.schedule(task, 1000);
    }
    public void stopTime(){
        timer.cancel();
    }



}

