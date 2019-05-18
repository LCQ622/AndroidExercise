package cn.mcandroid.test13.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySqliteOpenHelper  extends SQLiteOpenHelper{
    private String TAG="lcq";


    /**
     * 构造器
     * @param context 上下文
     * @param version 版本号
     */
    public MySqliteOpenHelper(Context context,  int version) {
        /**
         * context 上下文
         * name 数据库的文件名
         * factory 游标工厂,一般给null就可以.
         * version 版本号
         */
        super(context, "user.db", null, version);
    }


    /**
     * 数据库被第一次创建的时候被调用.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {


        Log.d(TAG, "onCreate: 数据库被第一次创建了");
        //SQL语句 注意:在使用SQLite数据库时候 整型为:INTEGER
        String CreateSQL="CREATE TABLE info (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "name VARCHAR(20),\n" +
                "phone_number VARCHAR(25)\n" +
                ");";
        //执行SQL语句.
        db.execSQL(CreateSQL);
    }

    /**
     * 数据库版本升级时候调用.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: 数据库由于:"+oldVersion+"被升级为:"+newVersion);

    }
}
