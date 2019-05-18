package cn.mcandroid.book.system_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mcandroid.book.R;
import cn.mcandroid.book.db.Book.Book;
import cn.mcandroid.book.db.Book.BookDao;

public class System_all extends AppCompatActivity {
    private ListView lv;
    BookDao dao = new BookDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_all);
        lv = (ListView) findViewById(R.id.activity_system_all_lv);
        setListView();
    }

    private void setListView() {
        List<Map<String,Object>>data=new ArrayList<>();

        for (Book book:dao.getALLBook()){
            String str=book.getBook_name();
            if(str.contains("《")&&str.contains("》")){

            }else {
                str="《"+str+"》";
            }
            Map<String,Object> map=new HashMap<>();
            map.put("title",str);
            map.put("content","作者："+book.getAuthor());
            map.put("stock","库存："+book.getStock());
            map.put("ISBN","ISBN："+book.getISBN());
            data.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.simple_item,new String[]{"title","content","stock","ISBN"},new int[]{R.id.simple_item_Tiele,R.id.simple_item_content,R.id.simple_item_size,R.id.simple_item_ISBN});
        lv.setAdapter(adapter);
    }
}
