package cn.mcandroid.test18;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<AppInfo> appInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        appInfoList = new ArrayList<>();
        int num=(int)(Math.random()*100);
        for (int i = 0; i < num; i++) {
            AppInfo appInfo = new AppInfo(android.R.drawable.btn_star_big_on, "应用:" + i, ((int)(Math.random()*100)) + "MB");
            appInfoList.add(appInfo);
        }
        MySimpleAdapter simpleAdapter = new MySimpleAdapter(this, R.layout.simple_item, appInfoList);
        lv.setAdapter(simpleAdapter);


    }


}
