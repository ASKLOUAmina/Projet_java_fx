package com.poo.project_zelda;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Joueur {
    private int speed;
    private double posX;
    protected double posY;
    protected Mouvement.Direction direction;
    String imgURI;

    public Joueur() {
        posX = Panel.SCREENWIDTH / 2.05;
        posY = Panel.SCREENHEIGHT / 2.05 - 20;
        imgURI = "boy_down_1.png";
    }

    public void setDefaultValues() {
        speed = 4;
    }

    public void update(Tuile[][] tiles) {
        if (direction == Mouvement.Direction.UP) {
            if (posY > speed) {
                posY -= speed;
            } else {
                posY = 0;
            }
            imgURI = "boy_up_1.png";
        }
        if (direction == Mouvement.Direction.DOWN) {
            if (posY < Panel.SCREENHEIGHT - speed) {
                posY += speed;
            } else {
                posY = Panel.SCREENHEIGHT;
            }
            imgURI = "boy_down_1.png";
        }
        if (direction == Mouvement.Direction.RIGHT) {
            if (posX < Panel.SCREENWIDTH - speed) {
                posX += speed;
            } else {
                posX = Panel.SCREENWIDTH;
            }
            imgURI = "boy_right_1.png";
        }
        if (direction == Mouvement.Direction.LEFT) {
            if (posX > speed) {
                posX -= speed;
            } else {
                posX = 0;
            }
            imgURI = "boy_left_1.png";
        }
    }

    public void paint(GraphicsContext gc, TuileManager tuileManager) {
        Image img = new Image(imgURI);
        tuileManager.paint(gc);
        gc.drawImage(img, posX, posY, Panel.TILESIZE, Panel.TILESIZE);
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }
}

