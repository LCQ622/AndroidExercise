package cn.mcandroid.book;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import cn.mcandroid.book.librarian_activity.LibrarianActivity;
import cn.mcandroid.book.system_activity.SystemActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText pwd;
    private Button btn_login;
    private Switch sw;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv = findViewById(R.id.activity_main_tv);
        sw = findViewById(R.id.sw);
        sw.setChecked(ReadBooleanSP("sw"));
        name = (EditText) findViewById(R.id.activity_main_ed_name);
        pwd = (EditText) findViewById(R.id.activity_main_ed_password);
        btn_login = (Button) findViewById(R.id.activity_main_btn_login);
        btn_login.setOnClickListener(this);
        if (!ReadBooleanSP("first")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("提示！").setMessage("默认的系统管理员账号为：root \n密码为：admin\n\n" +
                    "默认的图书管理员账号为：2 \n" +
                    "密码为：admin").show();
            WriteSP("first", true);
        }
        name.setText(ReadSP("name"));
        pwd.setText(ReadSP("pwd"));
        tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_btn_login:
                handleLogin();
                break;
            case R.id.activity_main_tv:
                new AlertDialog.Builder(this).setTitle("提示！").setMessage("默认的系统管理员账号为：root \n密码为：admin\n\n" +
                        "默认的图书管理员账号为：2 \n" +
                        "密码为：admin").show();
                break;
            default:
                break;
        }
    }

    private void handleLogin() {
        String NameText = name.getText().toString();
        String PasswordText = pwd.getText().toString();
        if (!NameText.equals("") && !PasswordText.equals("")) {
            if (NameText.equals("root") && PasswordText.equals("admin")) {
                if (sw.isChecked()) {
                    WriteSP("name", NameText);
                    WriteSP("pwd", PasswordText);
                    WriteSP("sw", true);
                } else {
                    WriteSP("name", "");
                    WriteSP("pwd", "");
                    WriteSP("sw", false);
                }
                Intent intent = new Intent(MainActivity.this, SystemActivity.class);
                startActivity(intent);
            }
            if (NameText.equals("2") && PasswordText.equals("admin")) {
                if (sw.isChecked()) {
                    WriteSP("name", NameText);
                    WriteSP("pwd", PasswordText);
                    WriteSP("sw", true);
                } else {
                    WriteSP("name", "");
                    WriteSP("pwd", "");
                    WriteSP("sw", false);
                }
                Intent intent = new Intent(MainActivity.this, LibrarianActivity.class);
                startActivity(intent);
            }

        }
    }


    public void WriteSP(String key, String values) {
        @SuppressLint("WrongConstant") SharedPreferences.Editor s = getSharedPreferences("a", MODE_APPEND).edit();
        s.putString(key, values);
        s.apply();
    }

    public void WriteSP(String key, boolean b) {
        @SuppressLint("WrongConstant") SharedPreferences.Editor s = getSharedPreferences("a", MODE_APPEND).edit();
        s.putBoolean(key, b);
        s.apply();
    }

    public String ReadSP(String key) {
        @SuppressLint("WrongConstant") SharedPreferences sp = getSharedPreferences("a", MODE_APPEND);
        return sp.getString(key, "");
    }

    public boolean ReadBooleanSP(String key) {
        @SuppressLint("WrongConstant") SharedPreferences sp = getSharedPreferences("a", MODE_APPEND);
        return sp.getBoolean(key, false);
    }
}
