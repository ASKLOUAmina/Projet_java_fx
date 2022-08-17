package com.poo.project_zelda;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class TimerAnimation extends AnimationTimer {
    Panel panel;
    Joueur joueur;
    GraphicsContext gc;
    GestClavier gestClavier;
    TuileManager tuileManager;

    public TimerAnimation(Panel panel, Joueur joueur, GestClavier gestClavier, TuileManager tuileManager) {
        this.joueur = joueur;
        this.panel = panel;
        this.gc = panel.getGraphicsContext2D();
        this.gestClavier = gestClavier;
        this.tuileManager = tuileManager;
    }

    @Override
    public void handle(long l) {
        joueur.direction = null;

        if(gestClavier.descend()) {
            joueur.direction = Mouvement.Direction.DOWN;
        }

        if(gestClavier.gauche()){
            joueur.direction = Mouvement.Direction.LEFT;
        }

        if(gestClavier.monte()){
            joueur.direction = Mouvement.Direction.UP;
        }

        if(gestClavier.droite()){
            joueur.direction = Mouvement.Direction.RIGHT;
        }

        panel.update();
        panel.paint();
        joueur.update(tuileManager.getTuiles());
        joueur.paint(gc, tuileManager);
    }
}
