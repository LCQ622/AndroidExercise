package cn.mcandroid.test10;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_name;
    private EditText user_pwd;
    private  Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getfindView();
        setOnClick();



    }

    /**
     * 设置点击事件
     */
    private void setOnClick() {
        btn_login.setOnClickListener(this);
    }

    /**
     * 拿到控件对象
     */
    public void getfindView() {
       user_name=(EditText)findViewById(R.id.user_name);
       user_pwd=(EditText)findViewById(R.id.user_pwd);
       btn_login=(Button)findViewById(R.id.btn_login);
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {

          switch (v.getId()) {
                      case R.id.btn_login:
                          HandleLogin();
                          break;
                      default:
                          break;
                  }
    }

    /**
     * 处理登录事件
     */
    private void HandleLogin() {
        String str=""+user_name.getText().toString()+user_pwd.getText().toString();
       boolean a=writeFile(str);
       if(a){
           Log.i("lcq","成功");
       }else{
           Log.i("lcq","失败");
       }

    }


    /**
     * 通过file方式写数据
     * @param str
     * @return
     */
    public boolean writeFile(String str) {

        FileOutputStream fos=null;
        try {
            fos=openFileOutput("userinfo.txt",MODE_PRIVATE);
            fos.write(str.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public String readFile(){
        FileInputStream fis=null;
        try {
            fis=openFileInput("userinfo.txt");
            byte buffer[]=new byte[fis.available()];
            fis.read(buffer);
            String str=new String(buffer);
            return  str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }




    /**
     * 通过SharedPreferences方式写入数据
     * @param userName
     * @param userPwd
     * @return
     */
    public boolean SPwrite(String userName,String userPwd){
        SharedPreferences.Editor sp= getSharedPreferences("user",MODE_PRIVATE).edit();
        sp.putString("UserName",userName);
        sp.putString("UserPwd",userPwd);
        sp.apply();
        return true;
    }


    /**
     * 通过SharedPreferences方式读取数据
     * @return
     */
    public String  getSPUserName(){
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
      return   sp.getString("UserName","");
    }
    public String  getSPUserPwd(){
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
      return   sp.getString("UserPwd","");
    }





}
