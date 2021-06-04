package JDBC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class SimpleJdbc {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String host = "localhost";
        String username = "root";
        String rootPassword = "q1w2e3r4";

        // Load the JDBC driver
//    Class.forName("com.mysql.jdbc.Driver"); //Deprecated
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Establish a connection
        connection = DriverManager
                .getConnection("jdbc:mysql://" + host + "/Users?"
                        + "user=" + username + "&password=" + rootPassword);

        System.out.println("Database connected");

        // Create a statement
        statement = connection.createStatement();

        // Execute a statement
        resultSet = statement.executeQuery("SELECT name, password FROM users");

        File file = new File("users.txt");
        file.createNewFile();

        FileWriter fw = new FileWriter(file, true);

        System.out.println("\n Query Results:");
        // Iterate through the result and print the student names
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String password = resultSet.getString(2);
            System.out.println(name + "\t" + password);

            fw.write(name);
            fw.write("\t");
            fw.write(password);
            fw.write("\n");

        }

        fw.close();
        // Close the connection
        connection.close();

        //read file
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            String nameRead = scan.next();
            String passwordRead = scan.next();

            System.out.println("name: " + nameRead + "\t" + "password: " + passwordRead);
        }
        scan.close();
    }
}
