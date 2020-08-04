package com.example.todolist_app;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 private ClickListener clicklistener;
 private GestureDetector gestureDetector;




public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
        }

        this.clicklistener = clicklistener;


public class RecyclerTouchListner implements RecyclerView.OnItemTouchListener {
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
