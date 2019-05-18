package cn.mcandroid.test32;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * 演示动态的水平进度条
 */
public class MainActivity extends AppCompatActivity {
    private ProgressBar pro;
    private TextView size;
    private Handler handler;
    private int num;


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到控件的对象
        pro = (ProgressBar) findViewById(R.id.progress3);
        size = findViewById(R.id.size);
    }

    private void han() {
        handler = new Handler() {
            /**
             * 重写方法handleMessage
             * @param msg
             */
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x111) {
                    pro.setProgress(num);
                    if (num < 100) {
                        size.setText(num + "%");
                    } else {
                        size.setText(100 + "%");
                    }
                } else {
                    size.setVisibility(View.GONE);
                    pro.setProgress(0);
                    new AlertDialog.Builder(MainActivity.this).setTitle("完成").setMessage("加载完成").show();
                }
            }
        };
    }

    /**
     * 线程
     */
    private void start() {
        //新建一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    num = init();
                    //实例化一个消息 Message对象
                    Message m = new Message();
                    //判断进度是否小于该进度条的最大值
                    if (num < pro.getMax()) {
                        //设置消息
                        m.what = 0x111;
                        //发送消息
                        handler.sendMessage(m);
                    } else {
                        //设置消息
                        m.what = 0x110;
                        //发送消息
                        handler.sendMessage(m);
                        //跳出循环
                        break;
                    }
                }
            }

            /**
             * 该方法每500毫秒产生一次随机数，并且累加
             * @return num
             */
            private int init() {
                num += Math.random() * 10;
                try {
                    //线程休眠500毫秒
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return num;
            }

        }).start();//启动线程
    }


    /**
     * 点击事件
     *
     * @param view
     */
    public void btn(View view) {
        pro.setProgress(0);
        size.setText(0 + "%");
        size.setVisibility(View.VISIBLE);
        num = 0;
        han();
        start();

    }


}
