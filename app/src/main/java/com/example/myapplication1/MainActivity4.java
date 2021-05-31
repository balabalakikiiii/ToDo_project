package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ImageView imageView = findViewById(R.id.goodbyedelay);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //通过加载xml动画设置文件来创建一个Animation对象
////                Animation animation= AnimationUtils.loadAnimation(MainActivity4.this,
////                        R.anim.alpha);
////                imageView.startAnimation(animation);
//
//                Animation animation= AnimationUtils.loadAnimation(MainActivity4.this,
//                        R.anim.rotate);
//                imageView.startAnimation(animation);
//            }
//        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过加载xml动画设置文件来创建一个Animation对象
                Animation animation = AnimationUtils.loadAnimation(MainActivity4.this,
                        R.anim.alpha);
                imageView.startAnimation(animation);

                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(3000);

                RotateAnimation rotateAnimation = new RotateAnimation(
                        0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3000);

                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        1, 0.5f,
                        1, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);

                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 1,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 1);
                translateAnimation.setDuration(3000);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(translateAnimation);

                imageView.startAnimation(animationSet);

                new Handler(new Handler.Callback() {
                    //处理接收到的消息的方法
                    @Override
                    public boolean handleMessage(Message arg0) {
                        //实现页面跳转
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 2000); //表示延时两秒进行任务的执行


//                private void enterHome(){
//                    Timer time = new Timer();
//                    TimerTask tk = new TimerTask() {
//                        Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//
//                            startActivity(intent);
//                            finish();
//                        }
//                    };time.schedule(tk, 2000);
//
//                }
//                Intent intent = new Intent();
//                intent.setClass(MainActivity4.this, MainActivity3.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
//                startActivity(intent);
            }
        });

    }
}
