package org.totalbeginner.myJDBC;

import org.totalbeginner.myJDBC.MySQLAccess; // Your other file

public class testJDBC {

    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}
