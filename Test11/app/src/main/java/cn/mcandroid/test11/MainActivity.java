package cn.mcandroid.test11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private EditText user_name;
    private EditText user_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Find();
        btn_login.setOnClickListener(this);
        setTXT();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Handelclick();

    }

    private void Find() {
        btn_login=(Button)findViewById(R.id.btn_login);
        user_name=(EditText)findViewById(R.id.user_name);
        user_pwd=(EditText)findViewById(R.id.user_pwd);
    }

    @Override
    public void onClick(View v) {
          switch (v.getId()) {
                      case R.id.btn_login:
                          File cachePath=this.getCacheDir();
                          File filePath=this.getFilesDir();

                          Log.d("lcq","cachePath--->"+cachePath);
                          Log.d("lcq","filePath--->"+filePath);
                          break;
                      default:
                          break;
                  }
    }

    public  void Handelclick() {
        Log.d("lcq","点击了按钮");
        String name=user_name.getText().toString();
        String pwd=user_pwd.getText().toString();

        //做一个空判断.
        if (!name.equals("")&&!pwd.equals("")){
            saveData(name,pwd);
        }else {
            Toast.makeText(MainActivity.this,"请输入用户名和密码!!!",Toast.LENGTH_SHORT).show();
        }

    }

    private void saveData(String name, String pwd) {
        File path=this.getFilesDir();
        File file =new File(path,"UserData.txt");
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(file);
            fos.write((name+","+pwd).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("lcq","保存成功");
            }
        }

    }


    /**
     * Android内部提供的写文件类.
     */
    public void opWrite(String str){
        FileOutputStream fos=null;
        try {
            fos=openFileOutput("UserData.txt",MODE_PRIVATE);
            fos.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public String  opread(){
        FileInputStream fis=null;
        try {
            fis=openFileInput("UserData.txt");
            byte[] buffer=new byte[fis.available()];
            fis.read(buffer);
            String str=new String(buffer);
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private String read() {
        File path=this.getFilesDir();
        File file=new File(path,"UserData.txt");
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(file);
            byte [] buffer=new byte[fis.available()];
            fis.read(buffer);
            String str= new String(buffer);
            StringTokenizer st=new StringTokenizer(str,",");
            return st.nextToken();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void setTXT() {
        user_name.setText(opread());
    }

}
