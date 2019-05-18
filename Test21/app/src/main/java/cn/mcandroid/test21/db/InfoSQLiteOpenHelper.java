package cn.mcandroid.test21.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InfoSQLiteOpenHelper extends SQLiteOpenHelper {
    public InfoSQLiteOpenHelper(Context context) {
        super(context, "info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE info(\n" +
                "id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "name varchar(20),\n" +
                "money DOUBLE\n" +
                ");";
        db.execSQL(sql);
        db.execSQL("INSERT INTO info (name,money) VALUES('刘畅',1000);");
        db.execSQL("INSERT INTO info (name,money) VALUES('傻强',500);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
