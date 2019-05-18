package cn.mcandroid.book.db.Book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private String tableName = "Book";
    private Context context;
    private BookSQLiteOpenHelper helper;

    public BookDao(Context context) {
        this.context = context;
        helper = new BookSQLiteOpenHelper(context);
    }

    /**
     * 该方法用于获取所有书籍
     *
     * @return List<Book>
     */
    public List<Book> getALLBook() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        List<Book> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Book book = new Book(cursor.getInt(cursor.getColumnIndex("id"))
                    , cursor.getString(cursor.getColumnIndex("book_name")),
                    cursor.getString(cursor.getColumnIndex("author")),
                    cursor.getString(cursor.getColumnIndex("ISBN")),
                    cursor.getString(cursor.getColumnIndex("date")),
                    cursor.getInt(cursor.getColumnIndex("stock")),
                    cursor.getString(cursor.getColumnIndex("msg"))
            );
            list.add(book);
        }
        return list;
    }


    /**
     * 该方法用于添加书籍
     *
     * @param book
     * @return
     */
    public boolean addBook(Book book) {

        if (book != null) {
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            if (book.getId() > 0) {
                values.put("id", book.getId());
            }
            if (book.getBook_name() != null) {
                values.put("book_name", book.getBook_name());
            }
            if (book.getAuthor() != null) {
                values.put("author", book.getAuthor());
            }
            if (book.getISBN() != null) {
                values.put("ISBN", book.getISBN());
            }
            if (book.getDate() != null) {
                values.put("date", book.getDate());
            }
            if (book.getStock() > 0) {
                values.put("stock", book.getStock());
            }
            if (book.getMsg() != null) {
                values.put("msg", book.getMsg());
            }
            long number = db.insert(tableName, null, values);
            db.close();
            if (number != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 该方法用于查询书籍，非全部
     *
     * @param book
     * @return
     */
    public List<Book> lookupBook(Book book) {
        if (book != null) {
            SQLiteDatabase db = helper.getReadableDatabase();
            List list = new ArrayList();
            StringBuffer sql = new StringBuffer(" 1=1 ");
            if (book.getId() > 0) {
                sql.append(" and id like ?");
                list.add(book.getId());
            }
            if (book.getBook_name() != null) {
                sql.append(" and book_name like ?");
                list.add(book.getBook_name());
            }
            if (book.getAuthor() != null) {
                sql.append(" and author like ?");
                list.add(book.getAuthor());
            }
            if (book.getISBN() != null) {
                sql.append(" and ISBN like ?");
                list.add(book.getISBN());
            }
            if (book.getDate() != null) {
                sql.append(" and date like ?");
                list.add(book.getDate());
            }
            if (book.getStock() > 0) {
                sql.append(" and stock like ?");
                list.add(book.getStock());
            }

            String[] data = new String[list.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = "%" + (String) list.get(i) + "%";
            }
            Cursor cursor = db.query(tableName, null, sql.toString(), data, null, null, null);
            List<Book> bookList = new ArrayList<>();
            while (cursor.moveToNext()) {
                Book b = new Book(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("book_name")),
                        cursor.getString(cursor.getColumnIndex("author")),
                        cursor.getString(cursor.getColumnIndex("ISBN")),
                        cursor.getString(cursor.getColumnIndex("date")),
                        cursor.getInt(cursor.getColumnIndex("stock")),
                        cursor.getString(cursor.getColumnIndex("msg"))
                );
                bookList.add(b);
            }
            return bookList;
        }
        return null;
    }


    public List<Book> cxBook(Book book) {
        if (book != null) {
            SQLiteDatabase db = helper.getReadableDatabase();
            List list = new ArrayList();
            StringBuffer sql = new StringBuffer(" 1=1 ");
            if (book.getBook_name() != null) {
                sql.append(" and book_name link ?");
                list.add(book.getBook_name());
            }
            if (book.getISBN() != null) {
                sql.append(" and ISBN link ?");
                list.add(book.getISBN());
            }
            String []strarr=new String[list.size()];
            for (int i = 0; i < strarr.length; i++) {
               strarr[i]= "%" + list.get(i) + "%";
            }
            Cursor cursor = db.query(tableName, null, sql.toString(), strarr, null, null, null);
            List<Book> bookList = new ArrayList<>();
            while (cursor.moveToNext()) {
                Book b = new Book(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("book_name")),
                        cursor.getString(cursor.getColumnIndex("author")),
                        cursor.getString(cursor.getColumnIndex("ISBN")),
                        cursor.getString(cursor.getColumnIndex("date")),
                        cursor.getInt(cursor.getColumnIndex("stock")),
                        cursor.getString(cursor.getColumnIndex("msg"))
                );
                bookList.add(b);
            }
            return bookList;
        }

        return null;
    }

    public boolean delBook(Book book) {
        if (book != null) {
            SQLiteDatabase db = helper.getWritableDatabase();
            List list = new ArrayList();
            StringBuffer sql = new StringBuffer(" 1=1 ");
            if (book.getId() > 0) {
                sql.append(" and id = ?");
                list.add(book.getId());
            }
            if (book.getBook_name() != null) {
                sql.append(" and book_name = ?");
                list.add(book.getBook_name());
            }
            if (book.getAuthor() != null) {
                sql.append(" and author = ?");
                list.add(book.getAuthor());
            }
            if (book.getISBN() != null) {
                sql.append(" and ISBN = ?");
                list.add(book.getISBN());
            }
            if (book.getDate() != null) {
                sql.append(" and date = ?");
                list.add(book.getDate());
            }
            if (book.getStock() > 0) {
                sql.append(" and stock = ?");
                list.add(book.getStock());
            }
            String[] strarr = new String[list.size()];
            for (int i = 0; i < strarr.length; i++) {
                strarr[i] = list.get(i).toString();
            }
            int number = db.delete(tableName, sql.toString(), strarr);
            db.close();
            if (number > 0) {
                return true;
            }
        }
        return false;
    }
}
