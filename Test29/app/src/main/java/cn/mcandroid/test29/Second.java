package cn.mcandroid.test29;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    private EditText ed_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ed_info = (EditText) findViewById(R.id.activity_second_ed_info);
        Intent intent = getIntent();
        String str1="用户名："+intent.getStringExtra("name")+"密码："+intent.getStringExtra("password");
        SharedPreferences sp=getSharedPreferences("a",MODE_PRIVATE);
        String  str2="用户名："+sp.getString("name","")+"密码："+sp.getString("password","");
        ed_info.setText(str2);

    }
}
