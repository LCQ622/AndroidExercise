package cn.mcandroid.test12;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;

import static android.text.format.Formatter.formatFileSize;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    public String TAG="lcq";
    private Button btn;
    private Button btn_sp;
    private Button btn_getSpace;
    private TextView tv;
    private EditText ed;
    private Switch sw;
    private  TextView yx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        SDpath();
        if(isFile()){
            btn.setText(ReadSd("a.txt"));
        }
        if(!ReadSP("a","name").equals("")){
            setTVtext(tv,ReadSP("a","name"),30);
        }

      sw.setChecked(getSwSP("sw","state"));
       if(getSwSP("sw","state")){
           yx.setTextColor( Color.parseColor("#00cc99"));
       }else {
           yx.setTextColor(Color.parseColor("#000000"));
       }




        btn.setOnClickListener(this);
        btn_getSpace.setOnClickListener(this);
        btn_sp.setOnClickListener(this);
        sw.setOnCheckedChangeListener(this);
    }

    private void find() {
        btn=(Button)findViewById(R.id.btn);
        btn_sp=(Button)findViewById(R.id.btn_sp);
        btn_getSpace=(Button)findViewById(R.id.btn_getSpace);
        tv=(TextView)findViewById(R.id.tv);
        ed=(EditText)findViewById(R.id.ed) ;
        sw=(Switch) findViewById(R.id.sw);
        yx=(TextView)findViewById(R.id.yx);
    }




    /**
     * 该方法用于判断SD卡是否存在
     * Environment.MEDIA_MOUNTED 为已经挂载.
     * Environment.MEDIA_UNMOUNTED 为不存在.
     */
    public void SDpath() {
        String str=Environment.getExternalStorageState();
        if(str.equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG,"SD卡已经挂载");
        }else if(str.equals(Environment.MEDIA_UNMOUNTED)){
            Log.d(TAG,"SD卡不存在.");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                handleClick();
                break;
            case R.id.btn_getSpace:
                getSDSpace();
                break;
            case R.id.btn_sp:
                WriteSP("a","name",getEdidText());
                break;

        }
    }

    /**
     * 使用  SharedPreferences存储数据
     * @param FileName
     * @param keyName
     * @param values
     */
    public void WriteSP( String FileName,String keyName ,String values) {
        SharedPreferences.Editor sped=getSharedPreferences(FileName,MODE_PRIVATE).edit();
        sped.putString(keyName,values);
        sped.apply();
    }
    public void WriteSP( String FileName,String keyName ,boolean values) {
        SharedPreferences.Editor sped=getSharedPreferences(FileName,MODE_PRIVATE).edit();
       sped.putBoolean(keyName,values);
        sped.apply();
    }


    /**
     * 读取SharedPreferences数据
     * @param FileName 文件名
     * @param keyName 键名
     * @return 对应键名里的值.
     */
    public String ReadSP(String FileName,String keyName ){
        SharedPreferences sp=getSharedPreferences(FileName,MODE_PRIVATE);
            return sp.getString(keyName,"");

    }

    public boolean getSwSP(String FileName,String keyName ) {
        SharedPreferences sp=getSharedPreferences(FileName,MODE_PRIVATE);
        return sp.getBoolean(keyName,false);
    }




    private void handleClick() {
       WriteFile("mcandroid");

    }

    public  void WriteFile(String str) {
        //得到SD卡的路径.
        File path=Environment.getExternalStorageDirectory();
        File file=new File(path,"a.txt");
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(file);
            fos.write(str.getBytes());
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
            }
        }
    }

    public  String ReadSd(String fileName) {
        File path=Environment.getExternalStorageDirectory();
        File fiel=new File(path,fileName);
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(fiel);
            byte buffer[]=new byte[fis.available()];
            fis.read(buffer);
            String str=new String(buffer);
            return  str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    public boolean isFile() {
        File path=Environment.getExternalStorageDirectory();
        File file=new File(path,"a.txt");
        if (file.exists()){
            return  true;
        }
        return false;
    }

    /**
     * 该方法用来获得SD的剩余空间
     */
    public void getSDSpace() {
        //得到SD卡的路径
        File path=Environment.getExternalStorageDirectory();
        //得到的是未使用空间的字节数.
        long s=path.getFreeSpace();
        /*将得到的未使用空间的字节数进行换算.得到GB,MB,KB的形式.
        *在使用这个 Formatter.formatFileSize方法的时候,要传入一个上下文context.
        * */
        String space=Formatter.formatFileSize(this,s);
        tv.setText(space);
        setTVtext(tv,space,36);

    }

    public void setTVtext(TextView textView,String txt,float size){
        textView.setText(txt);
        textView.setTextSize(size);
    }

    public String getEdidText(){
        return ed.getText().toString();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
                    case R.id.sw:

                      if(sw.isChecked()){
                          WriteSP("sw","state",sw.isChecked());
                         yx.setTextColor( Color.parseColor("#00cc99"));

                      }else {
                          WriteSP("sw","state",sw.isChecked());
                          yx.setTextColor(Color.parseColor("#000000"));
                      }
                        break;
                    default:
                        break;
                }
    }


}
