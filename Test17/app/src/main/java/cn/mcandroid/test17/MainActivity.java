package cn.mcandroid.test17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);


        //数据集合
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("icon", i % 2 == 0 ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
            map1.put("name", "功能" + i);
            map1.put("content", "这是用于功能" + i + "的内容");
            data.add(map1);
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.sip_item, new String[]{"icon", "name", "content"}, new int[]{R.id.sim_item_iv, R.id.sim_item_title, R.id.sim_item_content});
        lv.setAdapter(simpleAdapter);
    }





     /*   *//**
         *   new  ArrayAdapter
         *   参数1: 上下文;
         *   参数2: item布局文件的资源id
         *   参数3: 数据内容,需要的是String类型的数组.
         *//*

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.arr_item,getData(20));
        //设置适配器
        lv.setAdapter(adapter);

    }


    *//**
     * 该方法用来准备数据
     * @param size
     * @return
     *//*
    public String[] getData(int size) {
        String[] data= new String[size];
        for (int i = 0; i <data.length; i++) {
            data[i]="我是ListView"+i;
        }
        return data;
    }*/


}



