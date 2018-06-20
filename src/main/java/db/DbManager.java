package main.java.db;

import java.sql.*;


public class DbManager {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static String USER = "username";
    static String PASS = "password";

    Connection conn = null;
    Statement stmt = null;


    public DbManager() {
    }

    public void createDb() {

        try {
            //STEP 1: Register JDBC driver
            regiserDriver();
            //STEP 2: Open a connection
            openConnection();
            //STEP 3: Execute a query
            executeCreateDbQuery();
            //STEP 4: Close resources
            closeRes();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Register JDBC driver
     * <p>
     * forName() executes code in a static code block.
     * calls newInstance() voor jbc.Driver class,
     * (call the static initialization which will register the driver with the DriverManager).
     * <p>
     * ! do not need to create an instance to run the static block
     *
     * @throws ClassNotFoundException
     */
    private void regiserDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    private void openConnection() {
        System.out.println("Connecting to database...");
        try {
            //Attempts to establish a connection to the given database URL.
            //The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
            //parameter is a database URL of the form jdbc:subprotocol:subname
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeCreateDbQuery(){
        System.out.println("Creating database...");
        try {
            //Create object to execute a SQL statement
            stmt = conn.createStatement();
            //define SQL
            String sql = "CREATE DATABASE INKBOARD";
            //execute statement
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Database created successfully...");
    }

    /**
     * Close resources if still open
     *
     * @throws SQLException
     */
    private void closeRes() throws SQLException {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
           se2.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}

