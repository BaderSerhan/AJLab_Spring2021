/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author bader-aul
 */
public class OuterClass implements EventHandler<ActionEvent> {

    Button btn;
    TextField tf;
    Button bader;

    OuterClass() {

    }

    OuterClass(Button btn) {
        this.btn = btn;
    }

    OuterClass(TextField tf) {
        this.tf = tf;
    }

    OuterClass(Button btn, TextField tf) {
        this.btn = btn;
        this.tf = tf;
    }

    OuterClass(Button btn, TextField tf, Button bader) {
        this.btn = btn;
        this.tf = tf;
        this.bader = bader;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(btn)) {
            System.out.println("Outer event handler triggered by button: Hello World");
        } else if (event.getSource().equals(tf)) {
            System.out.println("Outer event handler triggered by text field.");
        } else if (event.getSource().equals(bader)) {
            System.out.println("Outer event handler triggered by button: Bader.");
        } else {
            System.out.println("Outer event handler triggered.");
        }
    }

}
