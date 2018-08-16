package com.example.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * Created by 张翔宇 on 2018/7/5.
 */

public class Myprogressbar extends ProgressBar {
    int ydown=0;
    int ymove=0;
    int progress;
    Paint paint=new Paint();
    //Context context;
    public Myprogressbar(Context context) {
        super(context);
    }

    public Myprogressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Myprogressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                ydown= (int) event.getY();
                progress=getProgress();
                break;
            case MotionEvent.ACTION_MOVE:
                ymove= (int) event.getY();
                setProgress(progress+ydown-ymove);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
