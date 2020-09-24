package com.example.zypherassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView textView;
    final static float step = 200;
    float ratio = 1.0f;
    int basedistance;
    float mbaseratio;
    float fontsize = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.zoom_textview);
        textView.setTextSize(fontsize+13);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getPointerCount()==2) {
            int action = event.getAction();
            int pureaction = action & MotionEvent.ACTION_MASK;
            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                basedistance = getDistance(event);
                mbaseratio = ratio;
            } else {
                float delta = (getDistance(event) - basedistance) / step;
                float multi = (float) Math.pow(2, delta);
                mbaseratio = Math.min(1024.0f, Math.max(0.1f, mbaseratio * multi));
                textView.setTextSize(mbaseratio + 13);
            }
        }
        return true;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
