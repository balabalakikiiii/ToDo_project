package com.example.myapplication1;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Kodulf on 2016/6/24.
 */

public class MyCountDownTimerView extends LinearLayout {
    /**
     * 首先实现倒计时的功能
     */
    private long leftTime;
    private boolean started = false;
    private Callback callback;

    public MyCountDownTimerView(Context context) {
        super(context);
    }

    public MyCountDownTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setText(long left){
        leftTime=left;
        String[] leftTimeFormatedStrings = getLeftTimeFormatedStrings(leftTime);
        int childCount = getChildCount();
        for (int i = 0; i < childCount/2; i++) {
            TextView childAt = (TextView) getChildAt(i*2);
            childAt.setText(leftTimeFormatedStrings[i]);
        }
    }

    public synchronized void start() {
        if(started==false) {
            started = true;
            Message message = new Message();
            mHandler.sendEmptyMessage(1);
        }
    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (started == true) {
                        if (leftTime > 1000) {
                            leftTime=leftTime-1000;
                            setText(leftTime);
                            mHandler.sendEmptyMessageDelayed(1, 1000);
                        } else {
                            //回调
                            callback.onFinish();
                        }
                    }
                    break;
                case 2:
                    leftTime=0l;
                    started=false;
                    setText(0l);
                    break;
            }
        }
    };


    public synchronized  void stop(){
        mHandler.sendEmptyMessage(2);
    }

    public interface Callback{
        void onFinish();
    }

    public void setOnCallback(Callback callback){
        this.callback=callback;
    }


    public String[] getLeftTimeFormatedStrings(long leftTime) {

        String days = "00";
        String hours = "00";
        String minutes = "00";
        String seconds = "00";

        if (leftTime > 0) {
            //实际多少秒
            long trueSeconds = leftTime / 1000;
            //当前的秒
            long secondValue = trueSeconds % 60;
            if (secondValue < 10) {
                seconds = String.valueOf("0" + secondValue);
            } else {
                seconds = String.valueOf(secondValue);
            }

            //当前的分
            long trueMinutes = trueSeconds / 60;
            long minuteValue = trueMinutes % 60;
            if (minuteValue < 10) {
                minutes = String.valueOf("0" + minuteValue);
            } else {
                minutes = String.valueOf(minuteValue);
            }


            //当前的小时数
            long trueHours = trueMinutes / 60;
            long hourValue = trueHours % 24;
            if (hourValue < 10) {
                hours = String.valueOf("0" + hourValue);
            } else {
                hours = String.valueOf(hourValue);
            }

            //当前的天数
            long dayValue = trueHours / 24;
            if (dayValue < 10) {
                days = String.valueOf("0" + dayValue);
            } else {
                days = String.valueOf(dayValue);
            }
        }
        return new String[]{days,hours,minutes,seconds};

    }
}

