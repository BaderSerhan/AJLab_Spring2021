package JDBC;

import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatabaseEx extends Application {

    private Button btnView = new Button("View");
    private Button btnInsert = new Button("Insert");
    private Button btnUpdate = new Button("Update");
    private Button btnClear = new Button("Clear");
    private TextField txtID = new TextField();
    private TextField txtLN = new TextField();
    private TextField txtFN = new TextField();
    private TextField txtMI = new TextField();
    private TextField txtAddress = new TextField();
    private TextField txtCity = new TextField();
    private TextField txtState = new TextField();
    private TextField txtTel = new TextField();
    private TextField txtEmail = new TextField();
    private Label lblRecord = new Label();
    private Label lblID = new Label("ID");
    private Label lblLN = new Label("Last Name");
    private Label lblFN = new Label("First Name");
    private Label lblMI = new Label("MI");
    private Label lblAddress = new Label("Address");
    private Label lblCity = new Label("City");
    private Label lblState = new Label("State");
    private Label lblTel = new Label("Telephone");
    private Label lblEmail = new Label("Email");
    private Statement statement;

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

        VBox vb = new VBox(5);
        HBox hb = new HBox(5);
        HBox hb1 = new HBox(5);
        HBox hb2 = new HBox(5);
        HBox hb3 = new HBox(5);
        HBox hb4 = new HBox(5);
        HBox hb5 = new HBox(5);

        vb.getChildren().addAll(hb, hb1, hb2, hb3, hb4);
        hb.getChildren().addAll(lblID, txtID);
        hb1.getChildren().addAll(lblLN, txtLN, lblFN, txtFN, lblMI, txtMI);
        hb2.getChildren().addAll(lblAddress, txtAddress);
        hb3.getChildren().addAll(lblCity, txtCity, lblState, txtState);
        hb4.getChildren().addAll(lblTel, txtTel, lblEmail, txtEmail);
        hb5.getChildren().addAll(btnView, btnInsert, btnUpdate, btnClear);

        BorderPane bp = new BorderPane();
        bp.setTop(lblRecord);
        bp.setCenter(vb);
        bp.setBottom(hb5);
        hb5.setAlignment(Pos.CENTER);
        Scene scene = new Scene(bp);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        TryInitializeDB();

        btnView.setOnAction(e -> {
            getStaffById();
        });

        btnInsert.setOnAction(e -> {
            insertResult();
        });

        btnUpdate.setOnAction(e -> {
            updateResult();
        });

        btnClear.setOnAction(e -> {
            //TODO
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void TryInitializeDB() throws ClassNotFoundException {
        try {
            String host = "localhost";
            String username = "root";
            String rootPassword = "q1w2e3r4";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://" + host + "/Staff?"
                            + "user=" + username + "&password=" + rootPassword);

            System.out.println("Db Connected");

            statement = connection.createStatement();

        } catch (SQLException ex) {
            System.out.println("Connection failed");
            lblRecord.setText("Connection failed" + ex);
        }
    }

    private void getStaffById() {
        //TODO
    }

    private void insertResult() {
        //TODO
    }

    private void updateResult() {
        //TODO
    }
}
