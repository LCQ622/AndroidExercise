package cn.mcandroid.test31;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        //对tabHost进行初始化。
        tabHost.setup();

        //通过LayoutInflater得到子标签布局文件
        LayoutInflater inflater = LayoutInflater.from(this);
        //通过LayoutInflater.inflate()方法加载标签页的布局文件
        // LayoutInflater.inflate()的第一参数是：资源id；第二参数是：viewGroup 对象，这里用tabHost.getTabContentView()得到。
        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2, tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("A").setContent(R.id.tab1_ll));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("B").setContent(R.id.tab2_ll));
        btn1 = findViewById(R.id.tab1_btn);
        btn2 = findViewById(R.id.tab2_btn);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab1_btn:
                Toast.makeText(MainActivity.this, btn1.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab2_btn:
                new AlertDialog.Builder(this).setTitle("提示").setMessage(""+btn2.getText()).show();
                break;
            default:
                break;
        }
    }
}
