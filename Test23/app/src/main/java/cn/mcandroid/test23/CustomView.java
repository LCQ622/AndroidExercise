package cn.mcandroid.test23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


/**
 * 自定义view 继承自view
 * 必须写构成方法
 */
public class CustomView extends View {
    //坐标
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

    public CustomView(Context context) {
        super(context);
        x = 10;
        y = 10;
    }


    /**
     * 重写onDraw方法
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //新建画笔对象
        Paint paint = new Paint();
        //BitmapFactory.decodeResource得到位图对象，第一参数为当前的资源，第二参数为图片的资源
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.lc);
        //绘制位图，第一参数为位图对象，第二、第三为坐标，第四位画笔对象
        canvas.drawBitmap(bitmap, x, y, paint);

        //判断是否回收
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
