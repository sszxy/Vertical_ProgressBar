package com.example.progressbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView brigttadd,brightreduce,sizeadd,sizereduce;
    Myprogressbar bright_progressbar;
    Textprogressbar text_progressbar;
    int bright_progress;
    int textsize_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

        brigttadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bright_progress=bright_progressbar.getProgress();
                bright_progress+=68;
                bright_progressbar.setProgress(bright_progress);

            }
        });
        brightreduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bright_progress= bright_progressbar.getProgress();
                bright_progress-=68;
                bright_progressbar.setProgress(bright_progress);
            }
        });
        sizeadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsize_progress= text_progressbar.getProgress();
                textsize_progress+=68;
                text_progressbar.setProgress(textsize_progress);

            }
        });

        sizereduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsize_progress= text_progressbar.getProgress();
                textsize_progress-=68 ;
                text_progressbar.setProgress(textsize_progress);
            }
        });
    }

    private void initview() {
        brigttadd= (ImageView) findViewById(R.id.add);
        brightreduce= (ImageView) findViewById(R.id.del);
        sizeadd= (ImageView) findViewById(R.id.text_add);
        sizereduce= (ImageView) findViewById(R.id.text_del);
        bright_progressbar= (Myprogressbar) findViewById(R.id.Myprogress);
        text_progressbar= (Textprogressbar) findViewById(R.id.text_Myprogress);
    }
}
