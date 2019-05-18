package cn.mcandroid.test26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import cn.mcandroid.test26.fragment.AFragment;
import cn.mcandroid.test26.fragment.BFragment;


public class MainActivity extends AppCompatActivity {
    private AFragment aFragment;
    private Button btn;
    private LinearLayout li ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li=(LinearLayout) findViewById(R.id.li);
        btn=new Button(this);
        btn.setText("按钮");
        btn.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        btn.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        li.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化fragment
                aFragment = new AFragment();
                //将fragment对象添加到FrameLayout布局中。
                //add方法的第一参数是FrameLayout布局的对象，第二参数是fragment的对象
                getSupportFragmentManager().beginTransaction().add(R.id.li, aFragment).commitAllowingStateLoss();
            }
        });




    }


}
