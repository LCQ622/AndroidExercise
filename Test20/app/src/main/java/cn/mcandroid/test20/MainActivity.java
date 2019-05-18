package cn.mcandroid.test20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String []data=new String[(int)(Math.random()*100)];
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        //String []data=new String[(int)(Math.random()*100)];
        for (int i = 0; i < data.length; i++) {
            data[i]="我是ListView"+i;
        }
        lv.setAdapter(new MyArrayAdapter(data,this));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent(MainActivity.this,Second.class);
        startActivity(intent);
    }
}
