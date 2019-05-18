package cn.mcandroid.test15.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public final String CreateTabelSQL="CREATE TABLE info (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "name VARCHAR(20),\n" +
            "phone_number VARCHAR(25)\n" +
            ");";


    public MySQLiteOpenHelper(Context context) {
        super(context, "user.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTabelSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
