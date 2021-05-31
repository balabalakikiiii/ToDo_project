package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    private EditText user;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btn_ConnectPi=findViewById(R.id.btn_ConnectPi);
        Button btn_newUser=findViewById(R.id.btn_newUser);
        user=findViewById(R.id.text_ip);
        password=findViewById(R.id.text_port);

        btn_ConnectPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=btn_ConnectPi.getText().toString();
                String password=user.getText().toString();
                Intent intent = new Intent();
                EditText et = (EditText) findViewById(R.id.text_port);
                String str = et.getText().toString();//获取编辑框里面的内容
                if (str.equals("123456")) {
                    Toast.makeText(MainActivity3.this, password+"登录成功", Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity3.this, MainActivity.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity3.this, "登录失败，请重新输入密码", Toast.LENGTH_SHORT).show();
                    et.setText(null);
                }



            }
        });

        btn_newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this, MainActivity10.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);

            }
        });



    }



    //    btn_ConnectPi.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Log.e(TAG, "onClick: ");
//        }
//    });


}