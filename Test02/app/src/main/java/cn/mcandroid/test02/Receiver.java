package cn.mcandroid.test02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"我是Test2:我收到来自Test01的广播",Toast.LENGTH_SHORT).show();
        Intent i=new Intent("cn.mcandroid.Test02");
        context.sendBroadcast(i);
    }
}
