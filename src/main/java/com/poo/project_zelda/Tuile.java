package com.poo.project_zelda;

import javafx.scene.image.Image;

public class Tuile {
    private Image image;
    private boolean collision = false;

    public Tuile(Image image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }

    public Image getImage(boolean isCollision) {
        return image;
    }

    public boolean getCollision() {
        return collision;
    }
}
