package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private static final String TAG ="task" ;

    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                Button btn=findViewById(R.id.btn);
                Button btn2=findViewById(R.id.btn2);
                Button btn3=findViewById(R.id.btn3);
                Button btn4=findViewById(R.id.btn4);
                Button btn_day01=findViewById(R.id.btn_day01);
                Button btn_day02=findViewById(R.id.btn_day02);
                Button btn_day03=findViewById(R.id.btn_day03);

                //点击事件
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e(TAG, "onClick: ");
                    }
                });

                //长按事件
               btn.setOnLongClickListener(new View.OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View v) {
                       Log.e(TAG, "onLongClick: ");
                       return false;
                   }
               });

               //触摸事件
               btn.setOnTouchListener(new View.OnTouchListener() {
                   @Override
                   public boolean onTouch(View v, MotionEvent event) {
                       Log.e(TAG, "onTouch: "+event.getAction());
                       return false;
                   }
               });

               btn_day01.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent();
                       intent.setClass(MainActivity.this, MainActivity2.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                       startActivity(intent);

                   }
               });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity6.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity11.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity9.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });

                }

           }




