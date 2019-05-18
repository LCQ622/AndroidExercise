package cn.mcandroid.test09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
    private Button second_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        //此处要得到这个控件的对象
        second_btn=(Button)findViewById(R.id.second_btn);
        //new 监听事件的对象
        MyClickListener listener=new MyClickListener();
        //设置该控件的点击监听,并传入监听事件的对象.
        second_btn.setOnClickListener(listener);
    }

    /**
     * 内部类,实现View.OnClickListener接口
     * 重写onClick方法
     *
     */
    class MyClickListener implements View.OnClickListener{
        /**
         * 在该方法里做相应的点击触发操作
         * @param v
         */
        @Override
        public void onClick(View v) {
              switch (v.getId()) {
                          case R.id.second_btn:
                              Toast.makeText(SecondActivity.this,"这是第二种点击事件",Toast.LENGTH_SHORT).show();
                              Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                              startActivity(intent);
                              break;
                          default:
                              break;
                      }
        }
    }
}
