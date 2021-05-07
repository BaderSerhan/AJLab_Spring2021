/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandlers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class EventHandlers extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button();
        btn.setText("Hello");

        Button btn2 = new Button("AJ");

        TextField tf = new TextField();

        OuterClass out = new OuterClass(tf);

        tf.setOnAction(out);

        btn.setOnAction(new InnerEventHandler(1));

        btn2.setOnAction(new InnerEventHandler());

        tf.setOnKeyPressed((event) -> {
//            System.out.println(event.getText());
//            System.out.println(event.getCode());

            if (event.getText().equalsIgnoreCase("r")) { //equalsIgnoreCase to be triggered when r or R is pressed
                System.out.println("Reloading app");
            }

            if (event.getCode() == KeyCode.Q) {
                System.out.println("Quitting app");
            }

        });

        VBox root = new VBox();
        root.getChildren().addAll(btn, tf, btn2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static class InnerEventHandler implements EventHandler<ActionEvent> {

        int number = 0;

        public InnerEventHandler() {

        }

        public InnerEventHandler(int number) {
            this.number = number;
        }

        @Override
        public void handle(ActionEvent event) {

            Button sourceBtn = (Button) event.getSource();

            //OR if (number == 1) => button 1 is pressed
            if (sourceBtn.getText().equals("Hello")) {
                System.out.println("Inner Event Handler triggered by button 1.");
            } else {
                System.out.println("Inner Event Handler triggered by button 2.");
            }
        }
    }
}
