package com.poo.project_zelda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Panel gridCanvas;
    TimerAnimation listener;
    GraphicsContext gc;
    Joueur zelda;
    GestClavier keyboard;
    TuileManager tileManager;

    @Override
    public void start(Stage stage) throws IOException {
        gridCanvas = new Panel(Panel.SCREENHEIGHT, Panel.SCREENWIDTH);
        Pane pane = new Pane(gridCanvas);
        Scene scene = new Scene(pane);
        gridCanvas.setDefaultValues(scene);
        gc = gridCanvas.getGraphicsContext2D();

        tileManager = new TuileManager(gridCanvas);
        tileManager.paint(gridCanvas.getGraphicsContext2D());

        zelda = new Joueur();
        zelda.setDefaultValues();

        keyboard = new GestClavier(scene);

        listener = new TimerAnimation(gridCanvas, zelda, keyboard, tileManager);
        listener.start();

        stage.setResizable(false);
        stage.setTitle("Mon Zelda");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}