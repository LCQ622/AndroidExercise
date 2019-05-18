package cn.mcandroid.test26.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.mcandroid.test26.R;

public class AFragment extends Fragment {
    @Nullable
    @Override
    /**
     * 1.得到fragment 的布局文件的view对象
     * 2.将的得到的view对象return返回。
     *
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //得到布局文件的view对象
        /**
         * inflater.inflate(）这个方法中的第一参数是：fragment布局文件的资源id。
         * 第二参数是：ViewGroup对象，这里传入onCreateView方法里的 container就可以了。
         *第三参数给定位false就可以了。
         */
        View view =inflater.inflate(R.layout.a_fragment,container,false);
        return view;
    }

    @Override
    /**
     * 在这个方法里要将fragment布局文件里的控件的对象获得。
     * 通过view的findViewById方法得到fragment布局文件里的控件对象。
     */
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获得fragment布局文件里的控件对象
        TextView tv=(TextView) view.findViewById(R.id.a_fragment_tv);
    }
}
