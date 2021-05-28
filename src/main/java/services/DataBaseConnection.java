package services;

import core.ReadProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection con = null;
    private static ReadProperties prop = new ReadProperties();


    static {
        String url = prop.getDbURL();
        String user = prop.getDbUser();
        String psw = prop.getDbPsw();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, psw);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

    }
    public static Connection getConnection(){
        return con;}

        public static void closeConnection() {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
}
