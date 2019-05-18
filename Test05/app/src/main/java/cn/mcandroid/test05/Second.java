package cn.mcandroid.test05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class Second extends Activity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

    }



    public void btn(View v) {
        finish();
    }


    public void btn8(View v){
        Intent intent=new Intent(Second.this,ThirdActivity.class);
        startActivity(intent);
    }
}
