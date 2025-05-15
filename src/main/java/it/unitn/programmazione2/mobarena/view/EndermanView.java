package it.unitn.programmazione2.mobarena.view;

import it.unitn.programmazione2.mobarena.model.EndermanModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class EndermanView extends ImageView {
    public static final Image ENDERMAN_IMAGE = new Image(Objects.requireNonNull(EndermanView.class.getResourceAsStream("/images/enderman.png")));

    public EndermanView(EndermanModel model) {
        setImage(ENDERMAN_IMAGE);
        setFitHeight(Constants.BLOCK_SIZE);
        setPreserveRatio(true);

        setLayoutX(model.coordinate.get().x() * Constants.BLOCK_SIZE);
        setLayoutY(model.coordinate.get().y() * Constants.BLOCK_SIZE);

        model.coordinate.addListener((observable, oldValue, newValue) -> {
            setLayoutX(newValue.x() * Constants.BLOCK_SIZE);
            setLayoutY(newValue.y() * Constants.BLOCK_SIZE);
        });
    }
}
