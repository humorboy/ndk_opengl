package com.learnopengles.android.cpp.lesson8;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class LessonEightGLSurfaceView extends GLSurfaceView {

    private Action mRender;

    // Offsets for touch events
    private float mPreviousX;
    private float mPreviousY;

    private float mDensity;

    public LessonEightGLSurfaceView(Context context) {
        super(context);
    }

    public LessonEightGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null) {
            float x = event.getX();
            float y = event.getY();

            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                if (mRender != null) {
                    float deltaX = (x - mPreviousX) / mDensity / 2f;
                    float deltaY = (y - mPreviousY) / mDensity / 2f;
                    mRender.setDelta(deltaX, deltaY);

                }
            }

            mPreviousX = x;
            mPreviousY = y;

            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }

    // Hides superclass method.
    public void setRenderer(Renderer renderer, float density) {
        mRender = (Action) renderer;
        mDensity = density;
        super.setRenderer(renderer);
    }
}
