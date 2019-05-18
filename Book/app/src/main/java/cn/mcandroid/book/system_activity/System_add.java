package cn.mcandroid.book.system_activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.mcandroid.book.R;
import cn.mcandroid.book.db.Book.Book;
import cn.mcandroid.book.db.Book.BookDao;

public class System_add extends AppCompatActivity {
    private EditText ed_book_name;//书籍名称
    private EditText ed_author;//作者
    private EditText ed_ISBN;//ISBN
    private EditText ed_date;//出版时间
    private EditText ed_stock;//库存
    private EditText ed_msg;//书籍简介
    private Button btn_action;//提交按钮

    BookDao dao = new BookDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_add);
        initView();
    }

    private void initView() {
        ed_book_name = (EditText) findViewById(R.id.activity_system_add_ed_book_name);
        ed_author = (EditText) findViewById(R.id.activity_system_add_ed_author);
        ed_ISBN = (EditText) findViewById(R.id.activity_system_add_ed_ISBN);
        ed_date = (EditText) findViewById(R.id.activity_system_add_ed_date);
        ed_stock = (EditText) findViewById(R.id.activity_system_add_ed_stock);
        ed_msg = (EditText) findViewById(R.id.activity_system_add_ed_msg);
        btn_action = (Button) findViewById(R.id.activity_system_add_btn_action);
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String book_name = ed_book_name.getText().toString();
                String author = ed_author.getText().toString();
                String ISBN = ed_ISBN.getText().toString();
                String date = ed_date.getText().toString();
                String  stock = ed_stock.getText().toString();
                String msg = ed_msg.getText().toString();

                if (!stock.equals("")&&new Integer(stock) != 0 &&!book_name.equals("")) {
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
                    if (new Integer(stock) > 0) {
                        book.setStock(new Integer(stock));
                    }
                    if (!msg.equals("")) {
                        book.setMsg(msg);
                    }


                    if (dao.addBook(book)) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(System_add.this);
                        alert.setTitle("提示").setMessage("《" + book.getBook_name() + "》" + "添加成功！").show();
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(System_add.this);
                        alert.setTitle("警告！").setMessage("添加失败！").show();
                    }
                }else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(System_add.this);
                    alert.setTitle("警告！").setMessage("书籍名不能为空并且库存不能为0").show();
                }


            }
        });
    }
}
