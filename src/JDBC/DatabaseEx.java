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
            try {
                getStaffById();
            } catch (SQLException ex) {
                ex.getErrorCode();
            }
        });

        btnInsert.setOnAction(e -> {
            try {
                insertResult();
            } catch (SQLException ex) {
                ex.getErrorCode();
            }
        });

        btnUpdate.setOnAction(e -> {
            try {
                updateResult();
            } catch (SQLException ex) {
                System.out.println("Failed to update record : " + ex);
            }
        });

        btnClear.setOnAction(e -> clearFields());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void TryInitializeDB() throws ClassNotFoundException, SQLException {

        String host = "localhost";
        String username = "root";
        String rootPassword = "q1w2e3r4";

        // Load the JDBC driver
//    Class.forName("com.mysql.jdbc.Driver"); //Deprecated
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Establish a connection
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://" + host + "/Staff?"
                        + "user=" + username + "&password=" + rootPassword);

        System.out.println("Database connected");

        // Create a statement
        statement = connection.createStatement();
    }

    private void getStaffById() throws SQLException {
        String getStaffByIdQueryString = "select * from staff where Id = " + "'" + txtID.getText().trim() + "'";
        ResultSet resultSet = statement.executeQuery(getStaffByIdQueryString);
        if (resultSet.next()) {
            txtLN.setText(resultSet.getString(2));
            txtFN.setText(resultSet.getString(3));
            txtMI.setText(resultSet.getString(4));
            txtAddress.setText(resultSet.getString(5));
            txtCity.setText(resultSet.getString(6));
            txtState.setText(resultSet.getString(7));
            txtTel.setText(resultSet.getString(8));
            txtEmail.setText(resultSet.getString(9));
            lblRecord.setText("Record Found");
        } else {
            lblRecord.setText("Record Not Found");
        }
    }

    private void insertResult() throws SQLException {
        String insertQueryString = "insert into staff (Id, lastName, firstName"
                + ", mi, address, city, state, telephone, email) values ('" + txtID.getText().trim() + "','"
                + txtLN.getText().trim() + "','"
                + txtFN.getText().trim() + "','"
                + txtMI.getText().trim() + "','"
                + txtAddress.getText().trim() + "','"
                + txtCity.getText().trim() + "','"
                + txtState.getText().trim() + "','"
                + txtTel.getText().trim() + "','"
                + txtEmail.getText().trim() + "')";

        statement.executeUpdate(insertQueryString);
    }

    private void updateResult() throws SQLException {
        String updateQueryString = "update staff set "
                + " lastName = '" + txtLN.getText().trim()
                + "' , firstName = '" + txtFN.getText().trim()
                + "' , mi = '" + txtMI.getText().trim()
                + "' , address = '" + txtAddress.getText().trim()
                + "' , city = '" + txtCity.getText().trim()
                + "' , state = '" + txtState.getText().trim()
                + "' , telephone = '" + txtTel.getText().trim()
                + "' , email = '" + txtEmail.getText().trim()
                + "' where id = '" + txtID.getText().trim() + "';";

        statement.executeUpdate(updateQueryString);
        lblRecord.setText("Data Updated");

    }

    private void clearFields() {
        txtID.setText("");
        txtLN.setText("");
        txtFN.setText("");
        txtMI.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtTel.setText("");
        txtEmail.setText("");
    }
}
