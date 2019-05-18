package cn.mcandroid.book.system_activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mcandroid.book.R;
import cn.mcandroid.book.db.Book.Book;
import cn.mcandroid.book.db.Book.BookDao;

public class System_del extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener ,DialogInterface.OnClickListener{
    private Button btn_lookup;
    private TextView tv_tip;
    private EditText ed_BookName;
    private EditText ed_ISBN;
    private ListView listView;
    private List<Book> booklist;
    BookDao dao = new BookDao(this);
    private  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_del);
        ed_BookName = findViewById(R.id.activity_system_del_book_name);
        ed_ISBN = findViewById(R.id.activity_system_del_ISBN);
        btn_lookup = findViewById(R.id.activity_system_del_btn_lookup);
        tv_tip = findViewById(R.id.activity_system_del_tip);
        tv_tip.setVisibility(View.GONE);
        listView = findViewById(R.id.activity_system_del_lv);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("警告！").setMessage("删除之前请先通过ISON号或者书籍名称查询书籍是否存在该库中！").show();
        btn_lookup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String BookName = ed_BookName.getText().toString();
        String ISBN = ed_ISBN.getText().toString();
        Book book = new Book();
        if (!BookName.equals("")) {
            book.setBook_name(BookName);
        }
        if (!ISBN.equals("")) {
            book.setISBN(ISBN);
        }
        if (book != null) {
            booklist = dao.lookupBook(book);
            setListView(booklist);
        }

    }

    public void setListView(List<Book> list) {
        if (list != null) {
            if (tv_tip.getVisibility() == View.GONE) {

                tv_tip.setVisibility(View.VISIBLE);
            }

        }
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
            map.put("ISBN", "ISBN：" + book.getISBN());
            data.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.simple_item, new String[]{"title", "content", "stock", "ISBN"}, new int[]{R.id.simple_item_Tiele, R.id.simple_item_content, R.id.simple_item_size, R.id.simple_item_ISBN});
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        position=i;
        String str = booklist.get(i).getBook_name();
        if (str.contains("《") && str.contains("》")) {

        } else {
            str = "《" + str + "》";
        }
        new AlertDialog.Builder(this).setTitle("警告！")
                .setMessage("是否删除？" + str)
                .setNeutralButton("是", this).setNegativeButton("否", null)
                .show();



        return true;
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Book b = new Book();
        b.setId(booklist.get(position).getId());
        if(dao.delBook(b)){
            Book book=new Book();
            book.setBook_name(ed_BookName.getText().toString());
            setListView(dao.lookupBook(book));
        }
    }
}
