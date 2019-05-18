package cn.mcandroid.test21;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.mcandroid.test21.adapter.Item;
import cn.mcandroid.test21.adapter.MySimpleAdapter;
import cn.mcandroid.test21.db.Info;
import cn.mcandroid.test21.db.InfoDao;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private InfoDao dao;
    private MySimpleAdapter mySimpleAdapter;

    private int num;
    private List<Item> data;
    List<Info> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new InfoDao(this);
        lv = (ListView) findViewById(R.id.lv);
        listView();


    }

    private void listView() {
        data = new ArrayList<>();
        list = dao.getAllInfo();
        for (Info info : list) {
            Item item = new Item();
            item.setIcon(R.drawable.jt);
            item.setTitle(info.getName());
            item.setContent("￥:" + info.getMoney());
            data.add(item);
        }
        mySimpleAdapter = new MySimpleAdapter(R.layout.simple_item, this, data);
        lv.setAdapter(mySimpleAdapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                for (Info i : dao.getAllInfo()) {
                    if (i.getName().equals("刘畅")) {
                        if (i.getMoney() > 0) {
                            num++;
                            dao.affair(100, "刘畅", "傻强");
                            Toast.makeText(MainActivity.this, "政府拨款啦(*ﾟｪﾟ*)", Toast.LENGTH_SHORT).show();
                            if (num == 5) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("感谢！").setMessage("感谢政府大大，祝你越来越美").show();
                            }
                            if (num == 10) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("哇塞！").setMessage("发财了").show();
                            }
                            listView();
                        }
                        if (i.getMoney() == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("警告！").setMessage("政府也没钱了").show();
                            num = 0;
                        }


                    }

                }


                break;
            case 1:
                dao.affair(100, "傻强", "刘畅");
                for (Info i : dao.getAllInfo()) {
                    if (i.getName().equals("傻强")) {
                        Toast.makeText(MainActivity.this, "上交，￥:100，就算上交所有都愿意", Toast.LENGTH_SHORT).show();
                        if (i.getMoney() == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("哈哈").setMessage("我说过的，就算上交所有的私房钱都原意，我乖吧？").
                                    setNeutralButton("乖", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(MainActivity.this, "那是当然ヽ(￣▽￣)ﾉ", Toast.LENGTH_SHORT).show();
                                        }
                                    }).setNegativeButton("不乖", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "净说瞎话(▼ヘ▼#)", Toast.LENGTH_SHORT).show();
                                }
                            }).setCancelable(false).show();
                        }
                    }
                }
                listView();
                break;
            default:
                break;
        }
    }
}
