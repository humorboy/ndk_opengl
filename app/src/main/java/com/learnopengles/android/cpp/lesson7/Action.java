package com.learnopengles.android.cpp.lesson7;

interface Action {
    void init();
    void destroy();
    void setDelta(float deltaX, float deltaY);
    void decreaseCubeCount();
    void increaseCubeCount();
    void toggleVBOs();
    void toggleStride();
}
