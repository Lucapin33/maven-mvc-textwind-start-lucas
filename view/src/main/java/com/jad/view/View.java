package com.jad.view;

import com.jad.controller.IController;
import com.jad.model.IModel;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;

public class View implements IView {
    private final IModel model;
    private IController controller;
    private TextWindow textWindow;

    public View(final IModel model) {
        this.model = model;
        TextWindowSettings textWindowSettings = new TextWindowSettings();
        textWindowSettings.setTitle("Xeno");
        textWindowSettings.setScreenHeight(100);
        textWindowSettings.setScreenWidth(200);//██
        textWindowSettings.setFontSize(6f);
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void display() {
        Screen screen = this.model.getScreen(new Dimension(100, 100));
        StringBuilder screenTxt = new StringBuilder();
        for (int y = 0; y < screen.getHeight(); y++){
            for (int x = 0; x < screen.getWidth(); x++){
                screenTxt.append(screen.getPixelAt(x, y).obstacle() ? "██" : "░░");
            }
            screenTxt.append("\n");
        }
        this.textWindow.display(screenTxt.toString());
    }
}
