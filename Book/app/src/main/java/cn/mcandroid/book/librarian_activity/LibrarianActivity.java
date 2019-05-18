package cn.mcandroid.book.librarian_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import cn.mcandroid.book.R;

public class LibrarianActivity extends AppCompatActivity  implements View.OnClickListener{
   private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian);
        tabHost=findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater=LayoutInflater.from(this);
        inflater.inflate(R.layout.activity_stock,tabHost.getTabContentView());
        inflater.inflate(R.layout.activity_user,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("activity_stock").setIndicator("库存管理").setContent(R.id.stock_rl));
        tabHost.addTab(tabHost.newTabSpec("activity_user").setIndicator("用户管理").setContent(R.id.user_rl));


    }

    @Override
    public void onClick(View view) {


    }
}
