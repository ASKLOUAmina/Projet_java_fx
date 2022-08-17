package com.poo.project_zelda;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TuileManager {
    private Panel gp;
    private List<Tuile> tuiles;
    private int[][] tileMap;

    public TuileManager(Panel gp) {
        this.gp = gp;
        tuiles = new ArrayList<>();

        tileMap = this.chargerCarte("C:/Users/SURFACE/OneDrive/Bureau/personal work/zelda/src/main/resources/map.txt");
        tuiles = this.getImages();
    }

    public List<Tuile> getImages() {
        List<Tuile> tuiles = new ArrayList<>();

        tuiles.add(new Tuile(new Image("grass.png", 48, 48, false, false), false));
        tuiles.add(new Tuile(new Image("earth.png", 48, 48, false, false), false));
        tuiles.add(new Tuile(new Image("foret.png", 48, 48, false, false), true));
        tuiles.add(new Tuile(new Image("sable.png", 48, 48, false, false), false));
        tuiles.add(new Tuile(new Image("coffre.png", 48, 48, false, false), true));

        return tuiles;
    }

    public int[][] chargerCarte(String carte) {
        int[][] res = new int[Panel.MAXSCREENROW][Panel.MAXSCREENROW];

        try {
            File file = new File(carte);
            FileInputStream fis = new FileInputStream(file);
            int r = 0;

            for (int i = 0; i < Panel.MAXSCREENROW; i++) {
                for (int j = 0; j < Panel.MAXSCREENCOL; j++) {
                    r = fis.read();

                    if (r == 32 || r == 10)
                        continue;
                    if (r != -1) {
                        res[i][j] = r - 48;
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public void paint(GraphicsContext gc) {

        for (int i = 0; i < Panel.MAXSCREENROW; i++) {
            for (int j = 0; j < Panel.MAXSCREENCOL; j++) {
                Tuile tuile = tuiles.get(tileMap[i][j]);
                gc.drawImage(tuile.getImage(tuile.getCollision()), j * Panel.TILESIZE, i * Panel.TILESIZE);
            }
        }
    }

    public Tuile[][] getTuiles() {
        Tuile[][] tabTuiles = new Tuile[Panel.MAXSCREENROW][Panel.MAXSCREENCOL];
        for (int i = 0; i < Panel.MAXSCREENROW; i++) {
            for (int j = 0; j < Panel.MAXSCREENCOL; j++) {
                tabTuiles[i][j] = this.tuiles.get(tileMap[i][j]);
            }
        }
        return tabTuiles;
    }
}
