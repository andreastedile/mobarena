package it.unitn.programmazione2.mobarena.view;

import it.unitn.programmazione2.mobarena.model.PlayerModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class PlayerView extends ImageView {
    public static final Image STEVE_IMAGE = new Image(Objects.requireNonNull(PlayerView.class.getResourceAsStream("/images/steve.png")));
    public static final Image STEVE_WITH_PUMPKIN_HEAD_IMAGE = new Image(Objects.requireNonNull(PlayerView.class.getResourceAsStream("/images/steve_with_pumpkin_head.png")));

    public PlayerView(PlayerModel model) {
        setFitHeight(Constants.BLOCK_SIZE);
        setPreserveRatio(true);
        setLayoutX(model.coordinate.get().x() * Constants.BLOCK_SIZE);
        setLayoutY(model.coordinate.get().y() * Constants.BLOCK_SIZE);
        if (model.wearsPumpkinHead.get()) {
            setImage(STEVE_WITH_PUMPKIN_HEAD_IMAGE);
        } else {
            setImage(STEVE_IMAGE);
        }

        model.wearsPumpkinHead.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                setImage(STEVE_WITH_PUMPKIN_HEAD_IMAGE);
            } else {
                setImage(STEVE_IMAGE);
            }
        });

        model.coordinate.addListener((observable, oldValue, newValue) -> {
            setLayoutX(newValue.x() * Constants.BLOCK_SIZE);
            setLayoutY(newValue.y() * Constants.BLOCK_SIZE);
        });
    }
}
