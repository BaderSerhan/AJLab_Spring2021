/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        //Grid Pane
        GridPane gp = new GridPane();

        RadioButton rb1 = new RadioButton("Radio Button 1");
        RadioButton rb2 = new RadioButton("Radio Button 2");

        ToggleGroup group = new ToggleGroup();

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);

        rb1.setSelected(false);
        rb2.setSelected(true);

        rb1.setStyle("-fx-focus-color:red;");
        rb2.setStyle("-fx-focus-color:green;");

        CheckBox box1 = new CheckBox("Check Box 1");
        CheckBox box2 = new CheckBox("Check Box 2");

        //first way to add to grid pane
        gp.add(rb1, 0, 0);
        gp.add(rb2, 1, 0);

        //another way to add to grid pane
//        GridPane.setRowIndex(box2, Integer.MIN_VALUE);
        //second way to add to row or column (addColumn)
        gp.addRow(1, box1, box2);

        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);

        //StackPane
        StackPane sp = new StackPane();
        TextArea txtArea = new TextArea();
        sp.getChildren().add(txtArea);
//        txtArea.setPrefWidth(50);
//        txtArea.setPrefHeight(50);
//        txtArea.setPrefSize(100, 100);
        txtArea.setPrefColumnCount(14);
        txtArea.setPrefRowCount(3);

        //Flow Pane
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(gp, sp);
        fp.setHgap(20);
        fp.setVgap(20);

        fp.setPadding(new Insets(10, 15, 20, 5));
        //even if we set orientation, flow pane changes with window resize
        fp.setOrientation(Orientation.HORIZONTAL);

        HBox hbox = new HBox();
        Button saveBtn = new Button("Save");
        Button cancelBtn = new Button("Cancel");

//        ProgressBar bar = new ProgressBar();
//        bar.setProgress(75);
        ProgressBar bar = new ProgressBar(0.75);

        hbox.getChildren().addAll(bar, cancelBtn, saveBtn);

        VBox vbox = new VBox(fp, hbox);

        //another way
//        vbox.getChildren().addAll(fp, hbox);
        //another way
//        vbox.getChildren().add(fp);
//        vbox.getChildren().add(hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);

        Scene scene = new Scene(vbox, 600, 600);

//        Scene scene1 = new Scene(new VBox(15, fp, hbox), 600, 600);
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
