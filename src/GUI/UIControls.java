/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class UIControls extends Application {

    @Override
    public void start(Stage primaryStage) {

        //one way
//        Pane root = new Pane(new Button("hello"));
//another way
        Button btn = new Button();
        btn.setText("Hello");

        Label l = new Label("Label 1");

        StackPane bader = new StackPane();
        bader.setAlignment(Pos.TOP_RIGHT);

        bader.getChildren().addAll(btn, l);

        Scene scene = new Scene(bader, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
