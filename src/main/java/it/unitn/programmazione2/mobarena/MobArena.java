package it.unitn.programmazione2.mobarena;

import it.unitn.programmazione2.mobarena.model.Coordinate;
import it.unitn.programmazione2.mobarena.model.EndermanModel;
import it.unitn.programmazione2.mobarena.model.PlayerModel;
import it.unitn.programmazione2.mobarena.view.Constants;
import it.unitn.programmazione2.mobarena.view.EndermanView;
import it.unitn.programmazione2.mobarena.view.PlayerView;
import it.unitn.programmazione2.mobarena.view.Terrain;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class MobArena extends Application {
    @Override
    public void start(Stage stage) {
        PlayerModel playerModel = new PlayerModel(new Coordinate(2, 4), true);
        playerModel.wearsPumpkinHead.set(false);

        EndermanModel endermanModel = new EndermanModel(new Coordinate(8, 4));
        endermanModel.triggered.bind(playerModel.wearsPumpkinHead.not());

        Terrain terrain = new Terrain(Constants.N_MAP_ROWS, Constants.N_MAP_COLUMNS);

        PlayerView playerView = new PlayerView(playerModel);
        EndermanView endermanView = new EndermanView(endermanModel);

        terrain.getChildren().add(playerView);
        terrain.getChildren().add(endermanView);

        Scene scene = new Scene(terrain, Constants.N_MAP_ROWS * Constants.BLOCK_SIZE, Constants.N_MAP_COLUMNS * Constants.BLOCK_SIZE);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    playerModel.coordinate.setValue(new Coordinate(playerModel.coordinate.get().x(), playerModel.coordinate.get().y() - 1));
                    break;
                case DOWN:
                    playerModel.coordinate.setValue(new Coordinate(playerModel.coordinate.get().x(), playerModel.coordinate.get().y() + 1));
                    break;
                case LEFT:
                    playerModel.coordinate.setValue(new Coordinate(playerModel.coordinate.get().x() - 1, playerModel.coordinate.get().y()));
                    break;
                case RIGHT:
                    playerModel.coordinate.setValue(new Coordinate(playerModel.coordinate.get().x() + 1, playerModel.coordinate.get().y()));
                    break;
                case KeyCode.E:
                    playerModel.wearsPumpkinHead.set(!playerModel.wearsPumpkinHead.get());
                    break;
            }
        });

        playerModel.coordinate.addListener((observable, oldValue, newValue) -> {
            if (endermanModel.triggered.get()) {
                int endermanX = endermanModel.coordinate.get().x();
                int endermanY = endermanModel.coordinate.get().y();
                int playerX = newValue.x();
                int playerY = newValue.y();
                int moveX = Integer.compare(playerX - endermanX, 0); // move towards player
                int moveY = Integer.compare(playerY - endermanY, 0);
                endermanModel.coordinate.setValue(new Coordinate(endermanX + moveX, endermanY + moveY));
            }
        });

        stage.titleProperty().bind(Bindings.createStringBinding(
                () -> playerModel.wearsPumpkinHead.get() ? "Mob Arena - Press E to take off the pumpkin head" : "Mob Arena - Press E to wear the pumpkin head",
                playerModel.wearsPumpkinHead
        ));

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}