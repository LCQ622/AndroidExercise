package cn.mcandroid.test19;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private Switch sw;
    private Button btn;
    private Button btn_view;
    private boolean is;


    private void to(String str) {

        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw = (Switch) findViewById(R.id.sw);
        btn = (Button) findViewById(R.id.btn);
        btn_view=(Button)findViewById(R.id.btn_webview);
        sw.setOnCheckedChangeListener(this);
        btn.setOnClickListener(this);
        btn_view.setOnClickListener(this);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.sw:
                is = isChecked;
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请回答").setIcon(android.R.drawable.btn_star_big_on).setMessage("你觉得这个软件如何?")
                        .setPositiveButton("很好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                to("这就对了嘛!");
                            }
                        }).setNeutralButton("一般", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        to("你再瞅瞅");
                    }
                }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        to("净说瞎话");
                    }
                });
                if (is) {
                    builder.setCancelable(false);
                } else {
                    builder.setCancelable(true);
                }
                builder.show();

                break;

            case R.id.btn_webview:
                Intent intent=new Intent(MainActivity.this,webView.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
