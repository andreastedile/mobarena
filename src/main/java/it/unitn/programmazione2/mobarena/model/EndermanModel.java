package it.unitn.programmazione2.mobarena.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class EndermanModel {
    public ObjectProperty<Coordinate> coordinate = new SimpleObjectProperty<>();
    public BooleanProperty triggered = new SimpleBooleanProperty(false);


    public EndermanModel(Coordinate coordinate) {
        this.coordinate.set(coordinate);
    }
}
