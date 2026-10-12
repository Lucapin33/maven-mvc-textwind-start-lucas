package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public enum MazeFactory {
    ;
    public static Maze makeFromFile(final String fileName){
        InputStream inputStream = MazeFactory.class.getResourceAsStream("/" + fileName);
        if (inputStream == null){
            throw new IllegalArgumentException("File " + fileName + " not found.");
        }
        try {
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            String[] lines = content.split("\n");
            final Dimension dimension = new Dimension(lines[0].length(), lines.length);
            Pixel[][] pixels = new Pixel[dimension.height][dimension.width];
            for (int y = 0; y < dimension.height; y++){
                for (int x = 0; x < dimension.width; x++){
                    pixels[y][x] = lines[y].charAt(x) == '1' ? new Pixel(true) : new Pixel(false);
                }
            }
            return new Maze(dimension, pixels);
        } catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
