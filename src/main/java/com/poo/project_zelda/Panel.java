package com.poo.project_zelda;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Panel extends Canvas {
    final static int TILESIZE = 48;
    final static int MAXSCREENCOL = 15;
    final static int MAXSCREENROW = 15;
    final static int SCREENWIDTH = TILESIZE * MAXSCREENCOL;
    final static int SCREENHEIGHT = TILESIZE * MAXSCREENROW;
    private GraphicsContext gc;
    private Scene scene;

    public Panel(int w, int h) {
        super(w, h);
        gc = this.getGraphicsContext2D();

        for (int i = 0; i < w; i += 50)
            gc.strokeLine(0, i, w, i);
        for (int i = 0; i < w; i += 50)
            gc.strokeLine(i, 0, i, h);
    }

    public void setDefaultValues(Scene scene) {
        this.scene = scene;
    }

    public void update() {
    }

    public void paint() {
    }
}
