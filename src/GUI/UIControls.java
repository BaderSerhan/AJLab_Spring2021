/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
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

        /*
         * First Pane = Grid Pane containing 2 radio buttons and 2 checkboxes
         * |Radio Btn 1 , Radio Btn 2 |
         * |Check Box 1 , Check Box 2 |
         *
         * Positions (column, row)
         * | (0, 0) , (1, 0) |
         * | (0, 1) , (1, 1) |
         */
        GridPane gp = new GridPane();

        /*
         * Creating the Radio Buttons
         */
        RadioButton rb1 = new RadioButton("Radio Button 1");
        RadioButton rb2 = new RadioButton("Radio Button 2");

        //adding toggle group to force only one radio button to be pressed at a time
        ToggleGroup group = new ToggleGroup();

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);

        //setting rb2 to be initially selected
        rb1.setSelected(false);
        rb2.setSelected(true);

        //using CSS styling to set the focus color of the radio button
        rb1.setStyle("-fx-focus-color:red;");
        rb2.setStyle("-fx-focus-color:green;");

        /*
         * Creating the Check Boxes
         */
        CheckBox box1 = new CheckBox("Check Box 1");
        CheckBox box2 = new CheckBox("Check Box 2");

        /*
         * Adding the nodes to the Grid Pane using one of the following methods:
         *
         * 1 - Adding each node alone using:
         * gp.add(node, columnIndex, rowIndex)
         *
         * 2 - Adding the nodes belonging to the same row (or column) together:
         * gp.addRow(rowIndex, nodes) OR gp.addColumn(columnIndex, nodes)
         *
         * 3 - Adding the nodes using:
         * gp.getChildren().addAll(nodes)
         *
         * and positioning them using GridPane's static methods:
         *
         * GridPane.setRowIndex(node, rowIndex) & GridPane.setColumnIndex(node,
         * columnIndex)
         * OR GridPane.setConstraints(node, columnIndex, rowIndex)
         */
        //first method: adding each node alone
        gp.add(rb1, 0, 0);
        gp.add(rb2, 1, 0);

        //second method: adding complete rows or columns
        gp.addRow(1, box1, box2);

        //extra GridPane setters
        gp.setAlignment(Pos.CENTER); //alignment of GridPane's children
        gp.setHgap(10); //horizontal spacing between gp's children
        gp.setVgap(10); //vertical spacing between gp's children

        /*
         * Second Pane = Stack Pane containing TextArea
         * Stack Pane positions its children in the center by default
         */
        StackPane sp = new StackPane();

        /*
         * Creating the TextArea and settings its size
         */
        TextArea txtArea = new TextArea();

        /*
         * 1 - Using setPrefHeight & setPrefWidth methods
         *
         * txtArea.setPrefWidth(50);
         * txtArea.setPrefHeight(50);
         *
         *
         * 2 - Using setPrefSize method which takes as parameters the width and
         * the height as double values
         *
         * txtArea.setPrefSize(100, 100);
         *
         *
         * 3 - Using setPrefColumnCount & setPrefRowCount which set the number
         * of characters that could fit in a column or row
         */
        txtArea.setPrefColumnCount(10); //i.e. approx. 10 characters in width
        txtArea.setPrefRowCount(3); //i.e. approx. 3 lines in height

        //Adding the TextArea to the StackPane
        sp.getChildren().add(txtArea);

        /*
         * Third Pane = Flow Pane with horizontal orientation which includes the
         * GridPane and the StackPane
         */
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(gp, sp);

        /*
         * even if orientation is set, flow pane changes with window resize
         * => setMinWidth & setMaxWidth will strictly set its width to the given
         * value
         */
        fp.setOrientation(Orientation.HORIZONTAL);
        fp.setMinWidth(500); //same as width of scene
        fp.setMaxWidth(500); // same as width of scene

        //extra FlowPane setters
        fp.setHgap(20); //horizontal space between children, i.e. between GridPane & StackPane
        //no need to setVgap since children are aligned horizontally
        fp.setAlignment(Pos.CENTER); //FlowPane aligns its children TOP_LEFT by default

        /*
         * Fourth Pane = HBox containing 2 Buttons and a ProgressBar
         */
        HBox hbox = new HBox();
        /*
         * Creating the Buttons
         */
        Button saveBtn = new Button("Save");
        Button cancelBtn = new Button("Cancel");

        /*
         * Creating the ProgressBar and setting its progress value using the
         * constructor
         */
        ProgressBar bar = new ProgressBar(0.75);

        /*
         * Alternatively, we can set the progress value using the corresponding
         * setter
         *
         * ProgressBar bar = new ProgressBar();
         * bar.setProgress(75);
         */
 /*
         * Adding the children to the HBox
         */
        hbox.getChildren().addAll(bar, cancelBtn, saveBtn);

        //extra HBox setters
        hbox.setAlignment(Pos.CENTER); //HBox default alignment is TOP_LEFT
        hbox.setSpacing(15); //horizontal space between children

        /*
         * Fifth Pane = VBox containing FlowPane & HBox
         * Adding the children to the VBox either directly in the constructor
         */
        VBox vbox = new VBox(fp, hbox);
        /*
         * OR
         * vbox.getChildren().addAll(fp, hbox);
         *
         * OR adding each node on its own
         *
         * vbox.getChildren().add(fp);
         * vbox.getChildren().add(hbox);
         */

        //extra VBox setters
        vbox.setAlignment(Pos.CENTER); //VBox default alignment is TOP_LEFT
        vbox.setSpacing(15); //vertical space between children

        //Adding the final pane containing my entire layout to the Scene
        Scene scene = new Scene(vbox, 500, 500);

        primaryStage.setTitle("GUI Controls");
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
