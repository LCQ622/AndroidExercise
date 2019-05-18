package cn.mcandroid.test04;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.mcandroid.service.MyService;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;

    private  MyServiceConnection myServiceConnection=new MyServiceConnection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        bind=(Button)findViewById(R.id.bind);
        unbind=(Button)findViewById(R.id.unbind);

        click click=new click();
        start.setOnClickListener(click);
        stop.setOnClickListener(click);
        bind.setOnClickListener(click);
        unbind.setOnClickListener(click);


    }

    private class click implements View.OnClickListener{
        Intent intent=new Intent(MainActivity.this,MyService.class);
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.start :
                    startService(intent);
                    break;
                case R.id.stop:
                    stopService(intent);
                    break;
               case R.id.bind:
                    /*Context.BIND_AUTO_CREATE 表示绑定的时候,如果service创建,则创建service*/
                    bindService(intent,myServiceConnection, Context.BIND_AUTO_CREATE);
                    break;
                case R.id.unbind:
                    unbindService(myServiceConnection);
                    break;
            }
        }
    }


    private class MyServiceConnection implements  ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("lcq",this.getClass().getName()+"---->onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("lcq",this.getClass().getName()+"---->onServiceDisconnected");
        }
    }
}
