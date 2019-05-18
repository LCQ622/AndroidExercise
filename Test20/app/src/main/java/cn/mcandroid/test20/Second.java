package cn.mcandroid.test20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Second extends Activity {
    private ListView second_lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        second_lv = (ListView) findViewById(R.id.second_lv);
        //生成数据
        List<Appinfo> data = new ArrayList<>();
        for (int i = 0; i < (int)(Math.random()*100); i++) {
            Appinfo info = new Appinfo();
            info.setIv(i % 2 == 0 ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
            info.setTitle("我是ListView" + i);
            info.setContent("我是ListView" + i + "内容");
            data.add(info);
        }
        //得到自己的ListView 适配器(MySimpleAdapter)
        MySimpleAdapter simpleAdapter = new MySimpleAdapter(data, this, R.layout.simple_item);
        //设置适配器.
        second_lv.setAdapter(simpleAdapter);

    }
}
