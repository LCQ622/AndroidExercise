package cn.mcandroid.test20;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static android.view.View.inflate;

public class MyArrayAdapter extends BaseAdapter {
    private String[]str;
   private Context context;


    public MyArrayAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @Override
    public int getCount() {
        return str.length;
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
         TextView tv =(TextView)View.inflate(context,R.layout.arr_item,null);
         tv.setText(str[position].toString());
        return tv;
    }
}
