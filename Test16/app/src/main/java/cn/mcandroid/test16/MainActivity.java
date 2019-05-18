package cn.mcandroid.test16;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        String [] str=new String[50];
        for (int i = 0; i < str.length; i++) {
             str[i]="MyArrayAdapter"+i;
        }
        lv.setAdapter(new MyArrayAdapter(this,R.layout.textview_item,str));

    }


    private class  MyArrayAdapter extends BaseAdapter{

        private Context context;
        private  int LayoutID;
        private String [] StrArray;
        //系统填充器
        private LayoutInflater inflater;

        public MyArrayAdapter(Context context, int layoutID, String[] strArray) {
            this.context = context;
            LayoutID = layoutID;
            StrArray = strArray;
            //在构造器里将填充器实例化出来.
            inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return StrArray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //使用系统的填充对象将view填充
            TextView tv= (TextView) inflater.inflate(LayoutID,null);
            //为每个textview设置内容
            tv.setText(StrArray[position]);
            return tv;
        }
    }



  /*  private  class  MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv=new TextView(MainActivity.this);
            tv.setText("哈哈:"+position);
            tv.setTextSize(30);
            return tv;
        }
    }*/
}
