package cn.mcandroid.test09;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourthActivity extends Activity {
    private Button fourth_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        //此处要得到这个控件的对象
        fourth_button=(Button)findViewById(R.id.fourth_btn);
        //设置该控件的点击监听,由于是匿名内部类,故此处直接new View.OnClickListener接口.
        fourth_button.setOnClickListener(new View.OnClickListener() {
            /**
             * 在该方法里做相应的点击触发操作
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(FourthActivity.this,"这是第四种点击事件",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
