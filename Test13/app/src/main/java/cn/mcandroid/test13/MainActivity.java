package cn.mcandroid.test13;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.mcandroid.test13.db.MySqliteOpenHelper;
import cn.mcandroid.test13.db.info;

public class MainActivity extends AppCompatActivity {
    private EditText ed_input;
    private Button btn_action;
    private Button btn_getall;
    private ListView lv;
    private String TAG="lcq";

    private SQLiteDatabase db;
    private List<info> infolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        setClick();

        MySqliteOpenHelper helper = new MySqliteOpenHelper(this, 3);
        db = helper.getWritableDatabase();


    }


    /**
     * 用于获得控件的对象
     */
    private void find() {
        ed_input = (EditText) findViewById(R.id.ed_input);
        btn_action = (Button) findViewById(R.id.btn_action);
        btn_getall = (Button) findViewById(R.id.btn_getall);
        lv=(ListView) findViewById(R.id.lv);
    }

    private void setClick() {
        MyClickListener listener = new MyClickListener();
        btn_action.setOnClickListener(listener);
        btn_getall.setOnClickListener(listener);
    }

    /**
     * 处理点击事件
     */
    public void handleClick() {
        ContentValues values = new ContentValues();
        String str=ed_input.getText().toString();
        if(!str.equals("")){
            values.put("name", str);
            db.insert("info", null, values);
        }
        values.clear();
    }

    /**
     * 处理查询的点击事件
     */
    public void handleGetAll() {
        infolist=getALLinfo();
        for(info in:infolist){
            Log.d(TAG, "用户数据: "+in.toString());
            setAdapter();
        }
    }

    public void setAdapter(){
        lv.setAdapter(new MyListViewAdapter());
    }

    /**
     * 获取所有数据
     */
    public List<info> getALLinfo() {
        List<info> list = new ArrayList<>();
        Cursor cursor = db.query("info", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            info info = new info(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("phone_number")));
            list.add(info);
            info = null;
        }
        return list;
    }


    /**
     * 点击监听内部类
     */
    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_action:
                    handleClick();
                    break;
                case R.id.btn_getall:
                    handleGetAll();
                    break;
                default:
                    break;
            }
        }
    }

    private class MyListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return infolist.size();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv=new TextView(MainActivity.this);
            tv.setText(infolist.get(position).getName());
            tv.setTextSize(36);
            return tv;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    }



}
