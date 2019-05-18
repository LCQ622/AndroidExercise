package cn.mcandroid.test24;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    private float x;
    private float y;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public MyView(Context context) {
        super(context);
        x=10;
        y=10;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),android.R.drawable.btn_star_big_on);
        canvas.drawBitmap(bitmap,x,y,paint);
        if(!bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
