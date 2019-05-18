package cn.mcandroid.test08;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_open;
    private Button btn_close;
    private BluetoothAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得一个BluetoothAdapter的对象.
        adapter = BluetoothAdapter.getDefaultAdapter();

        btn_open = (Button) findViewById(R.id.btn_open);
        btn_close = (Button) findViewById(R.id.btn_close);


        //判断该设备是否支持蓝牙功能

        if (adapter == null) {
            Msg("该设备不支持蓝牙功能");
        } else {
            Msg("可以使用蓝牙!!!");
        }

        //判断蓝牙是否打开
        if (adapter.isEnabled()) {
            btn_open.setText("蓝牙已打开");
        } else {
            btn_open.setText("蓝牙已关闭");
        }

        /**
         * 设置监听
         */
        MyClickListener listener = new MyClickListener();
        btn_open.setOnClickListener(listener);
        btn_close.setOnClickListener(listener);
    }

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_open:
                    if (adapter.isEnabled()) {
                        Msg("蓝牙已打开");
                    } else {
                        //打开蓝牙
                        adapter.enable();
                        btn_open.setText("蓝牙已打开");

                        /*这是另外一种打开蓝牙的方式*/
                        /*Intent open =new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivity(open);*/
                    }
                    /**
                     * 获取本地蓝牙适配器的信息
                     */
                    Log.d("lcq", "Name:" + adapter.getName() + ",MAC:" + adapter.getAddress());

                    break;

                case R.id.btn_close:
                    if (adapter.isEnabled()) {
                        adapter.disable();
                        btn_open.setText("蓝牙已关闭");
                        Msg("蓝牙已关闭!");
                    } else {
                        Msg("蓝牙已关闭!");
                    }
                    BlutoothState();
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 该方法用来文本提示
     * @param msg
     */
    private void Msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 该方法用来输出蓝牙的状态
     */
    private void BlutoothState() {
        switch (adapter.getState()) {
            case BluetoothAdapter.STATE_TURNING_ON:
                Log.d("lcq", "蓝牙正在打开");
            case BluetoothAdapter.STATE_ON:
                Log.d("lcq", "蓝牙已打开");
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                Log.d("lcq", "蓝牙正在关闭");
            case BluetoothAdapter.STATE_OFF:
                Log.d("lcq", "蓝牙已关闭");
                break;

            default:
                break;
        }
    }
}

