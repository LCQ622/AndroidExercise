package cn.mcandroid.test14.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import cn.mcandroid.test14.Tools.Constant;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.CREATE_SQL);
        Log.d(Constant.TAG, "数据库被创建 ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(Constant.TAG, "数据库由: " + oldVersion + "版本,升级到:" + newVersion + "版本");

    }
}
