package cn.mcandroid.test29;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import cn.mcandroid.test29.fragment.MyFragment;
import cn.mcandroid.test29.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity  {
    private LinearLayout layout;
    private EditText name;
    private  EditText pwd;
    private Button btn_login;
    private Button btn_new_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initFragment() {
        MyFragment myFragment=new MyFragment();
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl,myFragment);
        ft.commit();

    }

    private void initView() {
        name=(EditText) findViewById(R.id.activity_main_ed_name);
        pwd=(EditText) findViewById(R.id.activity_main_ed_password);
        btn_login=(Button)findViewById(R.id.activity_main_btn_login);
        btn_new_fragment=(Button)findViewById(R.id.activity_main_btn_new_fragment);
        //spread();
    }



    public void spread(){
        SharedPreferences sp=getSharedPreferences("a",MODE_PRIVATE);
        name.setText(sp.getString("name",""));
        pwd.setText(sp.getString("password",""));
    }



    public void NewFragment(View view){
        SecondFragment sf=new SecondFragment();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl,sf);
        ft.commit();
    }
    public void LoginClick(View view){
      String namestr=name.getText().toString();
      String pwdstr=pwd.getText().toString();

      if(!namestr.equals("")&&!pwdstr.equals("")){
          Intent intent=new Intent(MainActivity.this,Second.class);
          intent.putExtra("name",namestr);
          intent.putExtra("password",pwdstr);
          SharedPreferences.Editor se=getSharedPreferences("a",MODE_PRIVATE).edit();
          se.putString("name",namestr);
          se.putString("password",pwdstr);
          se.apply();
          startActivity(intent);
      }else {
          initFragment();
      }
    }



}
