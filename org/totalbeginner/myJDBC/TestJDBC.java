package org.totalbeginner.myJDBC;

import org.totalbeginner.myJDBC.MySQLAccess; // Your other file

public class testJDBC {

    // This is just a helper program to test your database connection
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}
