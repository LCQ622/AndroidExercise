package cn.mcandroid.book.db.Book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookSQLiteOpenHelper extends SQLiteOpenHelper {

    public BookSQLiteOpenHelper(Context context) {
        super(context, "BookInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Book(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "book_name VARCHAR(25),\n" +
                "author VARCHAR(25),\n" +
                "ISBN VARCHAR(25),\n" +
                "date DATE,\n" +
                "stock INT ,\n" +
                "msg VARCHAR(100)\n" +
                ");");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('Android移动应用基础教程','传智播客高教产品研发部','978-113-19620-2','2015-1',55,'改变中国的IT教育');");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('《JAVA语言程序设计》','孙丽娜','978-7-302-39119-7','2015-10',50,'适合高职院校用的java书籍');");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('《第一行代码——Android》','郭霖','978-7-115-36286-5','2014-8',50,'《第一行代码——Android》是Android初学者的最佳入门书。全书由浅入深、系统全面地讲解了Android软件开发的方方面面。第1章带领你搭建Android开发环境，完成你的第一个Android程序。第2章至第13章完整地讲解了Android开发中的各种基本知识和关键技术，包括四大组件、UI、碎片、广播机制、数据存储、服务、多媒体、网络、定位服务、传感器，以及分布式版本控制系统Git的使用等等。在部分章节会穿插相关技术的高级使用技巧。第14章和第15章则将带领你编写一个完整的项目，教会你如何打包、上架、嵌入广告并获得盈利。《第一行代码——Android》内容通俗易懂，既适合初学者循序渐进地阅读，也可作为一本参考手册，随时查阅。');");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('《疯狂Java讲义》','李刚','978-7-121-15578-9','2012',100,' 本书内容覆盖了Java的基本语法结构、Java的面向对象特征、Java集合框架体系、Java泛型、异常处理、Java GUI编程、JDBC数据库编程等内容。');");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('移动UI界面设计与实战','创锐设计','978-7-121-32980-7','2015-6',55,'大量讲解了移动UI界面的设计');");
        db.execSQL("INSERT  INTO Book(book_name,author,ISBN,date,stock,msg)VALUES('JSP程序设计','古声乐','978-7-81099-686-0','2009-8',55,'本教材为高职高专计算机及相关专业编写的教材。');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
