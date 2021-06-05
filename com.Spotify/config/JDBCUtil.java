package config;

public class JDBCUtil {
    
    private static final String user = "root";
    private static final String password = "adminkele";
    private static final String host = "localhost";
    private static final String database = "Spotify";
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
