package com.example.myapplication1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button btn_newDelete=findViewById(R.id.btn_newDelete);
        Button btn_newComplete=findViewById(R.id.btn_newComplete);


        btn_newDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity5.this, MainActivity3.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });
        btn_newComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity5.this, MainActivity.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });
    }


    public class TimeCount extends CountDownTimer {

        private Button timebutton;

        //参数依次为总时长,和计时的时间间隔
        public TimeCount(Button button, long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            this.timebutton = button;
        }

        //计时过程显示
        @Override
        public void onTick(long millisUntilFinished) {
            String time = "(" + millisUntilFinished / 1000 + ")秒";
            setButtonInfo(time, "#c1c1c1", false);
        }

        //计时完毕时触发
        @Override
        public void onFinish() {
            setButtonInfo("重新获取", "#f95353", true);
        }

        /**
         * 验证按钮在点击前后相关设置
         *
         * @param content 要显示的内容
         * @param color   颜色值
         * @param isClick 是否可点击
         */
        private void setButtonInfo(String content, String color, boolean isClick) {
            timebutton.setText(content);
            timebutton.setBackgroundColor(Color.parseColor(color));
            timebutton.setClickable(isClick);
        }
    }




}