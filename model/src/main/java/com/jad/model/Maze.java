package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;

public class Maze {
    private final Dimension dimension;
    private final Pixel[][] pixels;

    public Maze(Dimension dimension, Pixel[][] pixels) {
        this.dimension = dimension;
        this.pixels = pixels;
    }

    public int getHeight(){
        return this.dimension.height;
    }
    public int getWidth(){
        return this.dimension.width;
    }

    public Pixel getPixelAt(Point position){
        return this.getPixelAt(position.x, position.y);
    }
    public Pixel getPixelAt(final int x, final int y){
        if ((x < 0) || (x >= this.dimension.width) || (y < 0) || (y >= this.dimension.height)) {
            throw new IllegalArgumentException("Position (" + x + ", " + y + ") is out of range");
        }
        return this.pixels[y][x];
    }
}
