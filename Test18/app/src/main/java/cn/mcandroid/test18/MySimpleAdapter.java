package cn.mcandroid.test18;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class MySimpleAdapter extends BaseAdapter {

    private  int ItemID;
    private Context context;
    private List<AppInfo> appList;

    public MySimpleAdapter(Context context,int ItemID ,List<AppInfo> appList) {
        this.context = context;
        this.appList = appList;
        this.ItemID=ItemID;
    }

    @Override
    public int getCount() {
        return appList.size();
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
      View view  =  View.inflate(context,ItemID,null);

      //通过view.findViewById方法,得到控件的view对象.
        ImageView iv=(ImageView) view.findViewById(R.id.simple_item_iv);
        TextView title=(TextView)view.findViewById(R.id.simple_item_title);
        TextView size=(TextView)view.findViewById(R.id.simple_item_size);
        //从对象中获得值
        AppInfo info=appList.get(position);
        iv.setImageResource( info.getAPPicon());
        title.setText(info.getTitle());
        size.setText(info.getSize());
        return view;
    }
}
