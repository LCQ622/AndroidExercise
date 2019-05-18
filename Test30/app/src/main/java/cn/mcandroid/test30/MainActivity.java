package cn.mcandroid.test30;

import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    //声明全局属性
    private Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到控件的对象
        chronometer =findViewById(R.id.ch);
        //设置当前系统时间为起始时间
        chronometer.setBase(SystemClock.elapsedRealtime());
        //设置时间格式为：已用时间：00秒
        chronometer.setFormat("已用时间：%s");
        //启动计时
        chronometer.start();
        //为计时器添加监听器，当时间改变时，触发。
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //判断当前系统时间-计时器起始时间是否大于10秒（10000毫秒）
                if(SystemClock.elapsedRealtime()-chronometer.getBase()>10000){
                    //停止计时
                    chronometer.stop();
                    //弹出alerdialog 提示
                  new AlertDialog.Builder(MainActivity.this).setTitle("提示").setMessage("时间到").show();
                }
            }
        });
    }
}
