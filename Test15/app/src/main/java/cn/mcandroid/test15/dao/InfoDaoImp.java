package cn.mcandroid.test15.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.mcandroid.test15.db.Info;
import cn.mcandroid.test15.helper.MySQLiteOpenHelper;

public class InfoDaoImp implements InfoDao {

    private Context context;
    private MySQLiteOpenHelper helper;

    public InfoDaoImp() {
    }

    /**
     * 有参数构造器
     *
     * @param context 上下文
     */
    public InfoDaoImp(Context context) {
        this.context = context;
        //被new的时候创建
        helper = new MySQLiteOpenHelper(context);
    }


    /**
     * 获得所有信息
     *
     * @return
     */
    @Override
    public List<Info> getALLInfo() {
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Info> list = new ArrayList();
        /*
        query的第一参数是表名,查询所有的数据时,只要填第一参数即可
         */
        Cursor cursor = db.query("info", null, null, null, null, null, null);

        /*
        遍历cursor
         */
        while (cursor.moveToNext()) {
            Info i = new Info(cursor.getInt(cursor.getColumnIndex("id"))
                    , cursor.getString(cursor.getColumnIndex("name"))
                    , cursor.getString(cursor.getColumnIndex("phone_number")));
            list.add(i);
            //清空一下对象
            i = null;
        }
        //关闭数据库对象
        db.close();
        return list;
    }

    /**
     * 获得根据信息查询信息
     *
     * @param info
     * @return
     */
    @Override
    public List<Info> getInfoByInfo(Info info) {

        SQLiteDatabase db = helper.getReadableDatabase();
        //sql语句的where子句拼接
        StringBuffer sql = new StringBuffer(" 1=1 ");
        //该容器用于装query方法的第四参数的值
        List list = new ArrayList();
        if (info.getId() > 0) {

            sql.append("  and id=? ");
            list.add(info.getId());
        }
        if (!info.getName().equals("")) {

            sql.append(" and name=?");
            list.add(info.getName());
        }
        if (!info.getPhone_number().equals("")) {

            sql.append(" and phone_number =? ");
            list.add(info.getPhone_number());
        }
        //声明数组
        String strarr[] = new String[list.size()];
        //遍历容器,将容器里的值赋给String 数组,因为query方法的第四参数需要Sting数组.
        for (int i = 0; i < strarr.length; i++) {
            strarr[i] = list.get(i).toString();
        }
        /*
             query的第一参数是表名,
             第三参数是where条件子句,例如: id=?;
             第四参数是要插入的值,即占位的值,这里需要的是一个Srting 的数组.
         */
        Cursor cursor = db.query("info", null, sql.toString(), strarr, null, null, null);
        List<Info> InfoList = new ArrayList<>();
        while (cursor.moveToNext()) {
            Info i = new Info(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("phone_number")));
            InfoList.add(i);
            i = null;
        }
        return InfoList;
    }


    /**
     * 添加信息
     *
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    @Override
    public boolean addInfo(Info info) {
        if (info != null) {
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (info.getId() > 0) {
                values.put("id", info.getId());
            }
            if (info.getName() != null) {
                values.put("name", info.getName());
            }
            if (info.getPhone_number() != null) {
                values.put("phone_number", info.getPhone_number());
            }

            long num = db.insert("info", null, values);
            db.close();
            if (num != -1) {
                return true;
            }
        }

        return false;
    }


    /**
     * 删除信息
     *
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    @Override
    public boolean delInfo(Info info) {
        if (info != null) {
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            StringBuffer sql = new StringBuffer("1=1 ");
            List list = new ArrayList();
            if (info.getId() > 0) {
                values.put("id", info.getId());
                sql.append("  and id = ? ");
                list.add(info.getId());
            }
            if (info.getName() != null) {
                values.put("name", info.getName());
                sql.append(" and name = ? ");
                list.add(info.getName());
            }
            if (info.getPhone_number() != null) {
                values.put("phone_number", info.getPhone_number());
                sql.append(" and phone_number = ? ");
                list.add(info.getPhone_number());
            }

            String strArr[] = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = list.get(i).toString();
            }

            int num = db.delete("info", sql.toString(), strArr);
            db.close();
            if (num > 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * /**
     * 更新数据
     *
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    @Override
    public boolean updateInfo(Info info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        List list = new ArrayList<>();
        StringBuffer sql = new StringBuffer(" 1=1 ");

        if (info.getId() > 0) {
            sql.append(" and id=? ");
            list.add(info.getId());
        }
        if (info.getName() != null) {
            sql.append(" and name=? ");

            list.add(info.getName());
        }
        if (info.getPhone_number() != null) {
            sql.append(" and phone_number=? ");

            list.add(info.getPhone_number());
        }
        String[] strarr = new String[list.size()];
        for (int i = 0; i < strarr.length; i++) {
            strarr[i] = list.get(i).toString();
        }


        if (info.getUp_id() > 0) {
            values.put("id", info.getUp_id());
        }

        if (info.getUp_name() != null) {
            values.put("name", info.getUp_name());
        }
        if (info.getUp_phone_number() != null) {
            values.put("phone_number", info.getUp_phone_number());
        }
        int number = db.update("info", values, sql.toString(), strarr);
        db.close();
        if (number > 0) {
            return true;
        }
        return false;
    }
}
