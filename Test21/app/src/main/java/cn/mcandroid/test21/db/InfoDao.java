package cn.mcandroid.test21.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class InfoDao {

    private Context context;
    private InfoSQLiteOpenHelper helper;

    public InfoDao(Context context) {
        this.context = context;
        helper = new InfoSQLiteOpenHelper(context);
    }



    public void create (){
        SQLiteDatabase db=helper.getWritableDatabase();
    }


    public List<Info> getAllInfo(){
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("info",null,null,null,null,null,null);
        List<Info> list=new ArrayList<>();
        while(cursor.moveToNext()){
            Info i=new Info(cursor.getInt(cursor.getColumnIndex("id"))
                    ,cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getDouble(cursor.getColumnIndex("money")));
            list.add(i);
        }
        db.close();
        return  list;
    }


    public void affair(double money,String outName,String inputName ){
        SQLiteDatabase db=helper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            //SQL操作
            db.execSQL("update info set money=money-"+money+" where name=?",new String[]{outName});
            db.execSQL("update info set money=money+"+money+" where name=?",new String[]{inputName});
            //在这之前执行SQL 操作。
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
            db.close();
        }

    }
}
