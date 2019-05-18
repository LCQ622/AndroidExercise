package cn.mcandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("lcq",this.getClass().getName()+"服务被绑定");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("lcq",this.getClass().getName()+"服务解绑");
        return super.onUnbind(intent);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("lcq",Thread.currentThread().getName()+"服务被创建");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("lcq",Thread.currentThread().getName()+"服务启动");
        for (int i = 0; i <100; i++) {
            Log.d("lcq",i+"");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lcq",Thread.currentThread().getName()+"服务被停止");
    }



}
