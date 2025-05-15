package it.unitn.programmazione2.mobarena.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PlayerModel {
    public ObjectProperty<Coordinate> coordinate = new SimpleObjectProperty<>();
    public SimpleBooleanProperty wearsPumpkinHead = new SimpleBooleanProperty();

    public PlayerModel(Coordinate coordinate, boolean wearsPumpkinHead) {
        this.coordinate.set(coordinate);
        this.wearsPumpkinHead.set(wearsPumpkinHead);
    }
}
