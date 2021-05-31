package com.example.myapplication1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class MainActivity6 extends AppCompatActivity {
    private LinearLayout linearLayout;
    //Button索引
    private LinkedList<Button> ListBtn_Show;
    //TextView索引
    private LinkedList<TextView> ListText_Def;
    private Button btn_add, btn_edit;
    //判断btn_edit的状态
    private int EDITSTATE = 0;
    private EditText edit_hobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        inited();
    }

    private void inited() {
        edit_hobby = findViewById(R.id.edit_hobby);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        ListBtn_Show = new LinkedList<Button>();
        ListText_Def = new LinkedList<TextView>();
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBtn(String.valueOf(edit_hobby.getText()));//动态添加按钮
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断编辑按钮的状态
                if (EDITSTATE == 0) {
                    btn_edit.setText("完成");
                    EDITSTATE = 1;
                } else if (EDITSTATE == 1) {
                    btn_edit.setText("删除");
                    EDITSTATE = 0;
                }
            }
        });
    }

    private void addBtn(String str) {//动态添加按钮
        //添加承载两个按钮的LinearLayout
        LinearLayout linear_btn = new LinearLayout(this);
        linear_btn.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams liParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linear_btn.setLayoutParams(liParam);

        //添加Button
        Button btnShow = new Button(this);
        LinearLayout.LayoutParams btnAddPar = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, 150, 3);//设置宽高及占比
        btnAddPar.setMargins(0, 10, 0, 10);
        btnShow.setLayoutParams(btnAddPar);
        final int[] count = {0};
        btnShow.setText(str + "\t----已经打卡"+ count[0] +"天");
        btnShow.setTextColor(Color.rgb(255,255,255));
        btnShow.setBackground(getResources().getDrawable(R.drawable.shapedrawablehabit2));
        btnShow.setOnClickListener(new View.OnClickListener() {//动态添加点击事件
            @Override
            public void onClick(View view) {
                if (EDITSTATE == 1)
                    delBtn(view);//动态删除按钮
            }
        });
        linear_btn.addView(btnShow);//把btnShow添加到linear_btn中
        ListBtn_Show.add(btnShow);//把btnShow添加到索引中

        //添加TextView
        TextView textDef = new TextView(this);
        LinearLayout.LayoutParams btnDefPar = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, 80, 1);//设置宽高及占比
        btnDefPar.setMargins(0, 10, 0, 10);
        textDef.setLayoutParams(btnDefPar);
        textDef.setText("打卡");
        textDef.setGravity(Gravity.CENTER);
        textDef.setTextColor(Color.rgb(255,255,255));
        textDef.setBackground(getResources().getDrawable(R.drawable.shapedrawablehabit3));
        textDef.setOnClickListener(new View.OnClickListener() {//动态添加点击事件
            @Override
            public void onClick(View view) {
                count[0]++;
                btnShow.setText(str + "\t----已经打卡"+ count[0] +"次");
            }
        });
        linear_btn.addView(textDef);//把textDef添加到linear_btn中
        ListText_Def.add(textDef);//把textDef添加到索引中

        linearLayout.addView(linear_btn);//把linear_btn添加到外层linearLayout中
    }
    private void delBtn(View view) {//动态删除按钮
        if (view == null) {
            return;
        }
        int position = -1;
        for (int i = 0; i < ListBtn_Show.size(); i++) {
            if (ListBtn_Show.get(i) == view) {
                position = i;
                break;
            }
        }
        if (position >= 0) {
            ListBtn_Show.remove(position);//从索引中移除被删除的Button
            ListText_Def.remove(position);//从索引中移除被删除的TextView
            linearLayout.removeViewAt(position + 1);//在外出linearLayout删除内部指定位置所有控件
        }
    }
    private String inputTitleDialog() {
        final EditText inputServer = new EditText(this);
        final String[] string = new String[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入习惯").setView(inputServer).setNegativeButton("Cancel", null).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                string[0] = inputServer.getText().toString();
            }
        });
        builder.show();
        System.out.println("习惯1"+string[0]);
        return string[0];
    }



}