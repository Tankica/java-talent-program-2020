package com.company;

public class Box {
    private int width;
    private int height;
    private int depth;

    Box(int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int volume(){
        return height * width * depth;
    }
}
