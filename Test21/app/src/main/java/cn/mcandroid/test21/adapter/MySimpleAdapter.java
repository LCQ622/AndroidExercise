package cn.mcandroid.test21.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.mcandroid.test21.R;

public class MySimpleAdapter extends BaseAdapter {
    private int ItemId;
    private Context context;
    private List<Item>list;


    public MySimpleAdapter(int itemId, Context context, List<Item> data) {
        ItemId = itemId;
        this.context = context;
        this.list = data;
    }

    @Override
    public int getCount() {
        return list.size();
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
        View view=View.inflate(context,ItemId,null);
        ImageView jt=view.findViewById(R.id.jt);
        TextView title=view .findViewById(R.id.simple_Title);
        TextView content=view .findViewById(R.id.simple_content);

        Item item=list.get(position);
        jt.setImageResource(item.getIcon());
        title.setText(item.getTitle());
        content.setText(item.getContent());


        return view;
    }
}
