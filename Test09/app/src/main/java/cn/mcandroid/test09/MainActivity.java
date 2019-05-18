package cn.mcandroid.test09;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.KeyEvent;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private TextView bf;
    private TextView bfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt);
        bf=(TextView)findViewById(R.id.bf);
        bfa=(TextView)findViewById(R.id.bfa);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getKeyCode()) {

            case 4:
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("你确定退出吗?");
                alert.setCancelable(false);
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(1);
                    }
                });
                alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();

              return true;

                    case 24:
                        Toast.makeText(MainActivity.this,"按下音量+",Toast.LENGTH_SHORT).show();
                        break;
            case 25:
                Toast.makeText(MainActivity.this,"按下音量-",Toast.LENGTH_SHORT).show();
                break;
                    default:
                        break;
                }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        switch (event.getKeyCode()) {

            case 24:
                Toast.makeText(MainActivity.this,"松开音量+",Toast.LENGTH_SHORT).show();
                break;
            case 25:
                Toast.makeText(MainActivity.this,"松开音量-",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onKeyUp(keyCode, event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        txt.setText("X坐标:"+event.getX()+"\nY坐标:"+event.getY());

        if(event.getY()>700){
            bf.setText("下");
            bf.setTextSize(30);
            bfa.setText("半部分");
        }
        else {
            bf.setTextSize(40);
            bf.setText("上");
            bfa.setText("半部分");
        }
        return super.onTouchEvent(event);
    }

    /**
     * 这里的方法名直接写,布局文件中的  android:onClick属性的oneOnClick就可以了
     * @param view 这个是必须要传进来的.
     */
    public void oneOnClick(View view) {
        Toast.makeText(MainActivity.this,"这是第一种点击事件",Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
