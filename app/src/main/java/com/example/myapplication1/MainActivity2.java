package com.example.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    //声明submit
    Button submit;
    //声明LinearLayout
    LinearLayout linearLayout;
    private EditText ed1, ed2, ed3, ed4, ed5, ed6;
    private Button bn;
    private static final String TEMP_INFO="temp_info";
    private CheckBox checkBox;
    private SharedPreferences sp;
    private static final String SHOW="show";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //定位提交按钮
        submit=(Button)findViewById(R.id.sumbit);
        //按钮添加监听器
        submit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //声明字符串
                StringBuffer result=new StringBuffer();
                //声明选中的复选框的数量
                int resultCount=0;
                //获取复选框所在的布局
                linearLayout=(LinearLayout)findViewById(R.id.checklist);
                //获取复选框数量
                int count = linearLayout.getChildCount();
                //遍历复选框
                for(int i=0;i<count;i++){
                    //获取复选框
                    CheckBox checkBox=(CheckBox)linearLayout.getChildAt(i);
                    //判断复选框的选中状态，如果选中，就添加到结果字符串中
                    if(checkBox.isChecked()){
                        result.append(checkBox.getText());
                        resultCount++;
                    }
                }
                result.append("共完成了"+resultCount+"个任务");

                Toast.makeText(getApplicationContext(),result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        ed3 = (EditText)findViewById(R.id.ed3);
        ed4 = (EditText)findViewById(R.id.ed4);

        SharedPreferences sp = getSharedPreferences(TEMP_INFO, Context.MODE_PRIVATE);
        String content1 = sp.getString("info_content1", "");
        String content2 = sp.getString("info_content2", "");
        String content3 = sp.getString("info_content3", "");
        String content4 = sp.getString("info_content4", "");
        String content5 = sp.getString("info_content5", "");
        String content6 = sp.getString("info_content6", "");
        ed1.setText(content1);
        ed2.setText(content2);
        ed3.setText(content3);
        ed4.setText(content4);

    }
    protected void onStop(){
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences(TEMP_INFO,Context.MODE_PRIVATE).edit();
        editor.putString("info_content1", ed1.getText().toString());
        editor.putString("info_content2", ed2.getText().toString());
        editor.putString("info_content3", ed3.getText().toString());
        editor.putString("info_content4", ed4.getText().toString());

        editor.commit();
    }
    


}