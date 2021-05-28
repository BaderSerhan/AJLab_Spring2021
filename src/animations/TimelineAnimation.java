/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author bader-aul
 */
public class TimelineAnimation extends Application {

    private final ImageView backgroundImage = new ImageView("File:images/bg.jpg"); //File path on macOS => change to appropriate path for Windows machines
    private ImageView animatedImage;
    private String[] imagePaths = new String[9];
    private int index = 0;

    @Override
    public void start(Stage primaryStage) {

        for (int i = 1; i < 10; i++) {
            imagePaths[i - 1] = "File:images/" + i + ".png";
        }

        animatedImage = new ImageView(imagePaths[index]);

        animatedImage.setY(300);
        animatedImage.setFitHeight(300);
        animatedImage.setPreserveRatio(true);

        //create a stack pane to show two images on top of each other (animatedImage on top of backgroundImage)
        Pane root = new Pane();
        root.getChildren().addAll(backgroundImage, animatedImage);
//        root.setAlignment(Pos.BOTTOM_LEFT);

        /*
         * Either use StackPane with setAlignment
         * or Pane and setY
         */
        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), new AnimationEventHandler()));
        t.setCycleCount(Timeline.INDEFINITE);

        TranslateTransition pathT = new TranslateTransition(Duration.millis(5000));
        pathT.setNode(animatedImage);
        pathT.setFromX(-400);
        pathT.setToX(800);
        pathT.setCycleCount(Timeline.INDEFINITE);

        ParallelTransition parallel = new ParallelTransition(pathT, t);
        parallel.play();

        root.setOnMouseClicked((event) -> {
            if (parallel.getStatus() == Animation.Status.RUNNING) {
                parallel.pause();
            } else {
                parallel.play();
            }
        });

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Animation Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class AnimationEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (index == imagePaths.length - 1) {
                index = 0;
            } else {
                index++;
            }
            animatedImage.setImage(new Image(imagePaths[index]));

        }

    }
}
