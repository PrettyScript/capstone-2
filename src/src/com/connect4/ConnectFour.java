package com.connect4;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    private static final int TILE_SIZE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private Parent createContent() {
        Pane root = new Pane();

        // creating grid
        Shape gridShape = makeGrid();
        root.getChildren().add(gridShape);

        return root;
    }

    private Shape makeGrid() {
        Shape shape = new Rectangle((COLUMNS + 1) *
                TILE_SIZE, (ROWS + 1) * TILE_SIZE);

        for(int i=0; i< ROWS; i++) {
            for(int j=0; j<COLUMNS; j++) {
                Circle circle = new Circle(TILE_SIZE / 2);
                circle.setCenterX(TILE_SIZE / 2);
                circle.setCenterY(TILE_SIZE / 2);
                circle.setTranslateX(j * (TILE_SIZE + 5)
                        + TILE_SIZE / 4);
                circle.setTranslateY(i * (TILE_SIZE + 5)
                        + TILE_SIZE / 4);

                shape = shape.subtract(shape, circle);
            }
        }


        shape.setFill(Color.DARKBLUE);

        return shape;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
