package cn.mcandroid.test14.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.mcandroid.test14.Tools.Constant;
import cn.mcandroid.test14.db.User;
import cn.mcandroid.test14.helper.MySQLiteOpenHelper;

public class UserDao {
    private Context context;
    private MySQLiteOpenHelper helper = null;

    public UserDao(Context context) {
        this.context = context;
        helper = new MySQLiteOpenHelper(context, Constant.DATABASE_FILE_NAME, 1);
    }

    /**
     * 该方法用来查询所有的数据
     *
     * @return
     */
    public void getAllUser() {
        SQLiteDatabase db = helper.getReadableDatabase();
        /*
        得到SQLiteDatabase的对象db后,通过db.rawQuery方法执行查询语句.
        此时会返回一个Cursor对象,这时需要通过遍历Cursor
         */
        Cursor cursor = db.rawQuery("select * from user", null);
        //遍历Cursor   cursor.moveToNext()往下一个游标,到最后是会返回false.
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone_number = cursor.getString(cursor.getColumnIndex("phone_number"));
            Log.d("lcq", "id:"+id+",name:"+name+",phone_number:"+phone_number);
        }

        //用完数据库后记得关闭
        db.close();

    }


    /**
     * 添加数据
     * @param name
     * @param phone_number
     */
    public void addUser(String name, String phone_number) {
        if (!name.equals("") && !phone_number.equals("")) {
            //得到SQLiteDatabase的对象db
            SQLiteDatabase db = helper.getWritableDatabase();
            //Sql语句:values(?,?)这里的两个问号用来占位.
            String sql = "INSERT INTO user (name,phone_number) values(?,?)";
            //使用db.execSQL()方法,第一参数是SQL语句,第二个参数是占位的Object数组,数组里的元就是要插入的值.
            db.execSQL(sql, new Object[]{name, phone_number});

            db.close();
        }

    }


    /**
     * 删除数据
     * @param name
     */
    public void deleteUser(String name) {
        if (!name.equals("")) {
            //得到SQLiteDatabase的对象db
            SQLiteDatabase db = helper.getWritableDatabase();
            //Sql语句:这里的问号用来占位.
            String sql = "DELETE FROM user WHERE name=? ";
            //使用db.execSQL()方法,第一参数是SQL语句,第二个参数是占位的Object数组,数组里的元就是要删除的条件.
            db.execSQL(sql, new Object[]{name});
            db.close();

        }
    }

    public void deleteUser(String name, String phone_number) {
        if (!name.equals("") && !phone_number.equals("")) {
            SQLiteDatabase db = helper.getWritableDatabase();
            String sql = "DELETE FROM user WHERE name=? and  phone_number=? ";
            db.execSQL(sql, new Object[]{name, phone_number});
            db.close();
        }
    }


    /**
     * 修改数据
     * @param name
     * @param phone_number
     */
    public void updateUser(String name, String phone_number) {
        if (!name.equals("")) {
            //得到SQLiteDatabase的对象db
            SQLiteDatabase db = helper.getWritableDatabase();
            //Sql语句:这里的问号用来占位.
            String sql = "UPDATE user SET phone_number=? WHERE name=? ";
            /*使用db.execSQL()方法,第一参数是SQL语句,第二个参数是占位的Object数组,
            这里的数组第一个元素表示为要修改成的值,第二个元素为where的限制条件.
            切记update一定要设置where限制条件,不然全部数据会被修改.

            */
            db.execSQL(sql, new Object[]{phone_number, name});
            db.close();
        }

    }
}
