package config;

public class JDBCUtil {
    
    private static final String user = "root";
    private static final String password = "angelo10";
    private static final String host = "localhost";
    private static final String database = "spotify";
    private static final String port = "3306";

    public static String getURL(){
        return "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false";
    }

    public static String getUser(){
        return user;
    }

    public static String getPassword(){
        return password;
    }

}
