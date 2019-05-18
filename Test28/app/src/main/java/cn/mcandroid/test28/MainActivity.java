package cn.mcandroid.test28;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //声明控件的全局属性
    private Button btn;
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过 findViewById得到控件的对象
        btn = (Button) findViewById(R.id.btn);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkbox4);


        /**
         * 点击button的点击监听
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //声明一个字符串，用于用于装载CheckBox的内容
                String str = "";
                //通过CheckBox.isChecked()方法判断CheckBox是否被选中
                if (checkbox1.isChecked()) {
                    //如果被选中则进行字符串拼接
                    str += checkbox1.getText().toString()+"\n";
                }
                if (checkbox2.isChecked()) {
                    str += checkbox2.getText().toString()+"\n";
                }
                if (checkbox3.isChecked()) {
                    str += checkbox3.getText().toString()+"\n";
                }
                if (checkbox4.isChecked()) {
                    str += checkbox4.getText().toString();
                }


                //判读这个字符串是否有内容，如果没有，则CheckBox则没有选中。
                if(!str.equals("")){
                    //弹出提示CheckBox选中的内容。
                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("提示").setMessage(str).show();

                }else {
                    Toast.makeText(MainActivity.this,"你什么兴趣都没有选择哦！",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MainActivity.this,Second.class);
                    startActivity(intent);
                }


            }
        });
    }
}
