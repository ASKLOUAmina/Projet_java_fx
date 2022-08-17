package com.poo.project_zelda;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GestClavier {
    private Scene scene;
    private boolean monter, descendre, droite, gauche;

    public GestClavier(Scene scene) {
        this.scene = scene;
        this.gestionClavier();
        ;
    }

    public void gestionClavier() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.UP)
                    monter = true;
                if (keyEvent.getCode() == KeyCode.DOWN)
                    descendre = true;
                if (keyEvent.getCode() == KeyCode.LEFT)
                    gauche = true;
                if (keyEvent.getCode() == KeyCode.RIGHT)
                    droite = true;
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode code = keyEvent.getCode();
                if (keyEvent.getCode() == KeyCode.UP)
                    monter = false;
                if (keyEvent.getCode() == KeyCode.DOWN)
                    descendre = false;
                if (keyEvent.getCode() == KeyCode.LEFT)
                    gauche = false;
                if (keyEvent.getCode() == KeyCode.RIGHT)
                    droite = false;
            }
        });
    }

    public boolean monte() {
        return monter;
    }

    public boolean descend() {
        return descendre;
    }

    public boolean gauche() {
        return gauche;
    }

    public boolean droite() {
        return droite;
    }
}
