package cn.mcandroid.test24;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private MyView myView;
    private MyView myView2;
    private MyView myView3;
    private MyView myView4;
    private MyView myView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.fremelayout);



        myView=new MyView(this);
        myView2=new MyView(this);
        myView3=new MyView(this);
        myView4=new MyView(this);
        myView5=new MyView(this);


        myView.setOnTouchListener(this);
        frameLayout.addView(myView);
        frameLayout.addView(myView2);
        frameLayout.addView(myView3);
        frameLayout.addView(myView4);
        frameLayout.addView(myView5);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        myView.setX(motionEvent.getX());
        myView.setY(motionEvent.getY());

        myView2.setX(motionEvent.getX()-100);
        myView2.setY(motionEvent.getY());

        myView3.setX(motionEvent.getX()+100);
        myView3.setY(motionEvent.getY());

        myView4.setX(motionEvent.getX());
        myView4.setY(motionEvent.getY()-100);

        myView5.setX(motionEvent.getX());
        myView5.setY(motionEvent.getY()+100);

        myView.invalidate();
        myView2.invalidate();
        myView3.invalidate();
        myView4.invalidate();
        myView5.invalidate();
        return true;
    }
}
