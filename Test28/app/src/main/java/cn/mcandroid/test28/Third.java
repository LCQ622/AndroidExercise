package cn.mcandroid.test28;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TimePicker;
import android.widget.Toast;

public class Third extends AppCompatActivity {
private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        timePicker=(TimePicker) findViewById(R.id.timepicker);
        //将其设置成24小时制的
        timePicker.setIs24HourView(true);
        //设置事件改变监听
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            /**
             *
             * @param timePicker
             * @param i 小时
             * @param i1 分
             */
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                //日志输出选择的时间
                Log.d("lcq", i+"时"+i1+"分");
            }
        });
    }
}
