package cn.mcandroid.test02;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {
   private Receiver re;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
         re=new Receiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("cn.mcandoird.Test01");
        registerReceiver(re,filter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(re);
    }


}
