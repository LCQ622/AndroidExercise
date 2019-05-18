package cn.mcandroid.test20;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class MySimpleAdapter extends BaseAdapter {

    private List <Appinfo>list;
    private Context context;
    private int LayoutId;

    /**
     *
     * @param data 需要传入的是实体类为泛型的list集合
     * @param context 上下文
     * @param layoutId Item文件的资源id
     */
    public MySimpleAdapter(List <Appinfo> data, Context context, int layoutId) {
        this.list = data;
        this.context = context;
        LayoutId = layoutId;
    }

    /**
     *
     * @return 返回的是集合的大小
     */
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

        //得到item的对象
        View view=View.inflate(context,LayoutId,null);

        /******************************************************/
        /**
         * 得到item布局里的各个控件的对象
         */
        ImageView iv=view.findViewById(R.id.simple_iv);
        TextView title=view.findViewById(R.id.simple_title);
        TextView content=view.findViewById(R.id.simple_content);
        /**********************************************************/

        /************************************************************/
        //从list集合里得到当前位置的Appinfo的对象
        Appinfo info=  list.get(position);
        //为每个控件设置内容.
        iv.setImageResource(info.getIv());
        title.setText(info.getTitle());
        content.setText(info.getContent());
        /*************************************************************/
        return view;
    }
}
