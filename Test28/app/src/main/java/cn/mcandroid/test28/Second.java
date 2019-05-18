package cn.mcandroid.test28;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

public class Second extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //得到控件的对象
        DatePicker  dp=(DatePicker) findViewById(R.id.date_picker);

        //通过Calendar.getInstance()静态方法初始化一个日历对象
        final Calendar calendar=Calendar.getInstance();
        //初始化日期选择器
        dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                if((calendar.get(Calendar.DAY_OF_MONTH)+1)==i2){
                    Intent intent=new Intent(Second.this,Third.class);
                    startActivity(intent);
                }
                show(i,i1,i2);
            }
        });
    }


    /**
     * 该方法用于弹出 AlertDialog 显示日期
     * @param year
     * @param month
     * @param day
     */
    private void show(int year,int month,int day) {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("日期").setMessage(year+"年"+(month+1)+"月"+day+"日").show();
    }
}
