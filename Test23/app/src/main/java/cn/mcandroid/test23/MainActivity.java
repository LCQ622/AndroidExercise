package cn.mcandroid.test23;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //得到帧布局的对象
        FrameLayout frameLayout=(FrameLayout) findViewById(R.id.mylayout);

        //创建自定义view 的对象
        final CustomView customView=new CustomView(this);
        //设置触摸监听
        customView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //设置坐标
                customView.setX(motionEvent.getX()-149);
                customView.setY(motionEvent.getY()-175);
                //重绘
                customView.invalidate();
                return true;
            }
        });

        //切记最后记得将view添加到帧布局里
        frameLayout.addView(customView);

    }
}
