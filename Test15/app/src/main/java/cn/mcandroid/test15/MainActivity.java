package cn.mcandroid.test15;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cn.mcandroid.test15.dao.InfoDaoImp;
import cn.mcandroid.test15.db.Info;

public class MainActivity extends AppCompatActivity {

    private EditText edit_input_name;
    private EditText edit_input_phone_number;
    private Button btn_add;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_query;
    private Button btn_getinfo;
    private ListView lv;

    InfoDaoImp dao = new InfoDaoImp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setOnClick();
    }


    /**
     * 获得控件的view对象
     */
    private void findview() {
        edit_input_name = findViewById(R.id.edit_input_name);
        edit_input_phone_number = findViewById(R.id.edit_input_phone_number);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);
        btn_query = findViewById(R.id.btn_query);
        btn_getinfo = findViewById(R.id.btn_getinfo);
        lv = findViewById(R.id.lv);

    }

    private void setOnClick() {
        MyOnClickListener listener = new MyOnClickListener();
        btn_add.setOnClickListener(listener);
        btn_delete.setOnClickListener(listener);
        btn_update.setOnClickListener(listener);
        btn_query.setOnClickListener(listener);
        btn_getinfo.setOnClickListener(listener);
    }


    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_add:
                    add();
                    break;
                case R.id.btn_delete:
                    delete();

                    break;
                case R.id.btn_update:
                    update();
                    break;
                case R.id.btn_query:
                    query();

                    break;
                case R.id.btn_getinfo:
                    getInfo();
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * 处理查询所有的数据
     */
    private void query() {
        SetListViewdata(dao.getALLInfo());

    }

    private void SetListViewdata(List<Info> list) {
        String[] data = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Info in = list.get(i);
            data[i] = in.getName();
            in = null;
        }
        if (data != null) {
            lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, data));
        }
    }

    public void getInfo() {
        Info i = new Info();
        i.setName(edit_input_name.getText().toString());
        i.setPhone_number(edit_input_phone_number.getText().toString());
        SetListViewdata(dao.getInfoByInfo(i));
    }

    private void delete() {
        Info i = new Info();
        i.setName(edit_input_name.getText().toString());
        if (!i.getName().equals("")) {
            Log.d("lcq", "删除" + dao.delInfo(i));
        }
    }

    private void update() {
       /* InfoDaoImp dao = new InfoDaoImp(this);
        Info i = new Info();
        i.setName(edit_input_name.getText().toString());
        i.setUp_phone_number(edit_input_phone_number.getText().toString());
        boolean is = dao.updateInfo(i);
        Log.d("lcq", "update:" + is);*/

    }

    private void add() {
        Info i = new Info();
        String name = edit_input_name.getText().toString();
        String phone_number = edit_input_phone_number.getText().toString();
        if (!name.equals("") && !phone_number.equals("")) {
            i.setName(name);
            i.setPhone_number(phone_number);
        }
        if (i != null) {
           boolean is=dao.addInfo(i);
            if(is){
            Toast.makeText(MainActivity.this,"添加成功!",Toast.LENGTH_SHORT).show();
            }
            else {
            Toast.makeText(MainActivity.this,"添加失败!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
