package cn.mcandroid.test03;

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
    private int num;

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuffer str=new StringBuffer();
        final List<String>list=new ArrayList<>();
        for(int i=0;i<25;i++){
          /*  txt[i]= String.valueOf((char)(i+65));*/
           list.add((i+1)+"");
        }
        num=25;
        lv=(ListView)findViewById(R.id.lv);
        final ArrayAdapter adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,list.get(position)+"",Toast.LENGTH_SHORT).show();
            }
        });



        lv.setOnScrollListener(new OnScreenBottomOrTopListener() {
            @Override
            public void onScreenBottom() {
                super.onScreenBottom();
                Toast.makeText(MainActivity.this,"到底",Toast.LENGTH_SHORT).show();
                int a=0;
                for (int i = 0; i < 25; i++) {
                     a=i+num+1;
                    list.add(a+"");

                }
                num=a;

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onScreenTop() {
                super.onScreenTop();

            }
        });

    }
}
