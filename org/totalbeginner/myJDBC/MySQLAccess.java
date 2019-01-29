package org.totalbeginner.myJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the test DataBase - EVERYONE HAS ACCESS, PLEASE BE CAREFUL!!
            // Obviously, if you were distributing this file, you would not include the username and password. There are other ways...
            connect = DriverManager.getConnection("jdbc:mysql://54.89.64.80/CS485?user=CS485&password=WinonaState");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from CS485.Students");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String studentID = resultSet.getString("StudentID");
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String departmentID = resultSet.getString("DepartmentID");
            String advisorID = resultSet.getString("AdvisorID");
            System.out.println("StudentID: " + studentID);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("DepartmentID: " + departmentID);
            System.out.println("AdvisorID: " + advisorID);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
