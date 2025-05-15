package it.unitn.programmazione2.mobarena.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Grass extends ImageView {
    public static final Image GRASS_IMAGE = new Image(Objects.requireNonNull(Grass.class.getResourceAsStream("/images/grass.png")));

    public Grass() {
        setImage(GRASS_IMAGE);
        setFitHeight(GRASS_IMAGE.getHeight());
        setFitWidth(Constants.BLOCK_SIZE);
        setFitHeight(Constants.BLOCK_SIZE);
    }
}
