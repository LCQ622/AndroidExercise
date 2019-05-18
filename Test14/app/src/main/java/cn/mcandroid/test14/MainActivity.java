package cn.mcandroid.test14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import cn.mcandroid.test14.Tools.Constant;
import cn.mcandroid.test14.dao.UserDao;
import cn.mcandroid.test14.db.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_input_name;
    private EditText edit_input_phone_number;
    private Button btn_add;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_query;

    UserDao dao = new UserDao(this);

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

    }

    private void setOnClick() {
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query.setOnClickListener(this);
    }

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
            default:
                break;
        }
    }

    private void update() {
        String name=edit_input_name.getText().toString();
        String number=edit_input_phone_number.getText().toString();
        dao.updateUser(name,number);
    }

    private void delete() {
        String name=edit_input_name.getText().toString();
        String number=edit_input_phone_number.getText().toString();
        if(!name.equals("")&&number.equals("")){
            dao.deleteUser(name);
        }
        if(!name.equals("")&&!number.equals("")){
            dao.deleteUser(name,number);
        }

    }

    private void add() {
      dao.addUser(edit_input_name.getText().toString(),edit_input_phone_number.getText().toString());
    }

    private void query() {
        dao.getAllUser();
    }
}
