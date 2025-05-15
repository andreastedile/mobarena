package it.unitn.programmazione2.mobarena.view;

import javafx.scene.layout.Pane;

public class Terrain extends Pane {
    public Terrain(int nRows, int nCols) {
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                Grass grass = new Grass();
                grass.setLayoutX(col * Constants.BLOCK_SIZE);
                grass.setLayoutY(row * Constants.BLOCK_SIZE);
                getChildren().add(grass);
            }
        }
    }
}
