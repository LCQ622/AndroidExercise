package cn.mcandroid.book.system_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mcandroid.book.R;
import cn.mcandroid.book.db.Book.Book;
import cn.mcandroid.book.db.Book.BookDao;

public class System_lookup extends AppCompatActivity {
    private EditText ed_book_name;
    private EditText ed_author;
    private EditText ed_ISBN;
    private EditText ed_date;
    private ListView lv;


    BookDao dao = new BookDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_lookup);
        initView();

    }

    private void initView() {
        ed_book_name = (EditText) findViewById(R.id.activity_system_lookup_ed_book_name);
        ed_author = (EditText) findViewById(R.id.activity_system_lookup_ed_author);
        ed_ISBN = (EditText) findViewById(R.id.activity_system_lookup_ed_ISBN);
        ed_date = (EditText) findViewById(R.id.activity_system_lookup_ed_date);
        lv = (ListView) findViewById(R.id.activity_system_lookup_lv);
    }

    /**
     * 处理查找的点击事件
     */
    public void handleClick(View view) {
        String book_name = ed_book_name.getText().toString();
        String author = ed_author.getText().toString();
        String ISBN = ed_ISBN.getText().toString();
        String date = ed_date.getText().toString();
        //如果都为空就不进行操作
        if (!book_name.equals("")||!author.equals("") || !ISBN.equals("")||!date.equals("")) {
            Book book = new Book();
            if (!book_name.equals("")) {
                book.setBook_name(book_name);
            }
            if (!author.equals("")) {
                book.setAuthor(author);
            }
            if (!ISBN.equals("")) {
                book.setISBN(ISBN);
            }
            if (!date.equals("")) {
                book.setDate(date);
            }
            setListView(dao.lookupBook(book));
        }
    }


    private void setListView(List<Book> list) {
        List<Map<String, Object>> data = new ArrayList<>();
        for (Book book : list) {
            String str = book.getBook_name();
            if (str.contains("《") && str.contains("》")) {

            } else {
                str = "《" + str + "》";
            }
            Map<String, Object> map = new HashMap<>();
            map.put("title", str);
            map.put("content", "作者：" + book.getAuthor());
            map.put("stock", "库存：" + book.getStock());
            map.put("ISBN","ISBN："+book.getISBN());
            data.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.simple_item,new String[]{"title","content","stock","ISBN"},new int[]{R.id.simple_item_Tiele,R.id.simple_item_content,R.id.simple_item_size,R.id.simple_item_ISBN});
        lv.setAdapter(adapter);
    }


}
