package cn.mcandroid.book.system_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.mcandroid.book.R;

public class SystemActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private Button btn_del;
    private Button btn_lookup;//查找
    private Button btn_up;
    private Button btn_all;//全部

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        initView();
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.activity_system_btn_add);
        btn_del = (Button) findViewById(R.id.activity_system_btn_del);
        btn_lookup = (Button) findViewById(R.id.activity_system_btn_lookup);
        btn_up = (Button) findViewById(R.id.activity_system_btn_up);
        btn_all = (Button) findViewById(R.id.activity_system_btn_all);

        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_lookup.setOnClickListener(this);
        btn_up.setOnClickListener(this);
        btn_all.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.activity_system_btn_add:
                intent = new Intent(SystemActivity.this, System_add.class);
                startActivity(intent);
                break;
            case R.id.activity_system_btn_del:
                intent =new Intent(SystemActivity.this,System_del.class);
                startActivity(intent);
                break;
            case R.id.activity_system_btn_lookup:
                intent =new Intent(SystemActivity.this,System_lookup.class);
                startActivity(intent);
                break;
            case R.id.activity_system_btn_up:
                break;
            case R.id.activity_system_btn_all:
                intent = new Intent(SystemActivity.this, System_all.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
