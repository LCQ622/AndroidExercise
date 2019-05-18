package cn.mcandroid.test09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 在主类中实现View.OnClickListener接口
 */
public class ThirdActivity extends Activity implements View.OnClickListener {
    private Button third_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        //获得要被监听的控件的view对象
        third_btn=(Button)findViewById(R.id.third_btn);
        /*设置该控件的点击监,注意,由于这里的主类实现View.OnClickListener接口,所以这里要传入的对象自然是this 了*/
        third_btn.setOnClickListener(this);
    }

    /**
     * 实现View.OnClickListener接口后,重写该方法,在这里做点击触发的操作.
     * @param v
     */
    @Override
    public void onClick(View v) {
          switch (v.getId()) {
                      case R.id.third_btn:
                          Toast.makeText(ThirdActivity.this,"这是第三种点击事件",Toast.LENGTH_SHORT).show();
                          Intent intent=new Intent(ThirdActivity.this,FourthActivity.class);
                          startActivity(intent);
                          break;
                      default:
                          break;
                  }
    }
}
