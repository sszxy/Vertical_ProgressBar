package com.example.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ProgressBar;

/**
 * Created by 张翔宇 on 2018/7/6.
 */

public class Textprogressbar extends ProgressBar {
    Paint paint;
    Context context;
    int color=0xFFF7F6F7;
    int ydown;
    int ymove;
    int progress;
    int changeprogress;
    int sym;
    public  int level1;
    public  int level2;
    public  int level3;
    public  int level4;
    public  int level5;
    public Textprogressbar(Context context) {
        super(context);
        init(context);
    }
    public boolean change;
    public Textprogressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Textprogressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init(Context context){
        paint=new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(dip2px(context,1));
        this.context=context;
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
                changeprogress=progress+ydown-ymove;
                change=true;
                setProgress(changeprogress);
                break;
            case MotionEvent.ACTION_UP:
                if(change==true){
                if(changeprogress>level5){
                    if(changeprogress-level5<sym){
                        setProgress(level5);
                    }else{
                        setProgress(getHeight());
                    }
                }else if (changeprogress>level4&&changeprogress<level5){
                    if(changeprogress-level4<sym) {
                        setProgress(level4);
                    }
                    else{
                        setProgress(level5);
                    }
                }else if (changeprogress>level3&&changeprogress<level4){
                    if (changeprogress-level3<sym){
                        setProgress(level3);
                    }
                    else {
                        setProgress(level4);
                    }
                }else if (changeprogress>level2&&changeprogress<level3){
                    if (changeprogress-level2<sym){
                        setProgress(level2);
                    }
                    else {
                        setProgress(level3);
                    }

                }else if (changeprogress>level1&&changeprogress<level2){
                    if (changeprogress-level1<sym){
                        setProgress(level1);
                    }
                    else {
                        setProgress(level2);
                    }

                }else {
                        setProgress(level1);
                }
                change=false;
                }
                break;
        }
        return true;
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        super.layout(l, t, r, b);
        Log.d("tag",getHeight()+"");
        level5=getHeight()/6*5;
        level4=getHeight()/6*4;
        level3=getHeight()/6*3;
        level2=getHeight()/6*2;
        level1=getHeight()/6*1;
        sym=getHeight()/12;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=1;i<=5;i++){
            canvas.drawLine(0,getHeight()/6*i,getWidth(),getHeight()/6*i,paint);
        }

    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
