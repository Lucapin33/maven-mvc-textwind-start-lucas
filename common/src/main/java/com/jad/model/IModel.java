package com.jad.model;

import com.jad.view.Screen;

import java.awt.*;

public interface IModel {
    Screen getScreen(Dimension dimension);
    void loadMaze(final String fileName);

}
