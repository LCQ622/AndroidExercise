package cn.mcandroid.test17;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends BaseAdapter {
    private Context mContext;
    private int LayoutId;
    private String strArr[];

    public MyArrayAdapter(Context context, int resource, String[] Str) {
        mContext = context;
        LayoutId = resource;
        strArr = Str;
    }

    @Override
    public int getCount() {
        return strArr.length;
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
        TextView tv = (TextView) View.inflate(mContext, LayoutId, null);
        tv.setText(strArr[position]);
        return tv;
    }
}
