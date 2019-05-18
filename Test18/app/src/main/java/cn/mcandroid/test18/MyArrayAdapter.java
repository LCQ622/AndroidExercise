package cn.mcandroid.test18;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * 继承自BaseAdapter,这样要重写的方法少一些
 */
public class MyArrayAdapter extends BaseAdapter {
    private Context mContext;
    private String []StrArr;
    private int LayoutId;

    public MyArrayAdapter(Context mContext , int layoutId,String[] data) {
        this.mContext = mContext;
        StrArr = data;
        LayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return StrArr.length;
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
        // 通过View.inflate方法得到TextView对象
        TextView tv= (TextView) View.inflate(mContext,LayoutId,null);
        tv.setText(StrArr[position]);
        return tv;
    }
}
