package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JDBCUtil;
import model.Song;



public class SongDAO {
    
    public void add(Song song) {

        String INSERT_USER_SQL = "INSERT INTO Spotify.Cancion (Pista_idPista)"
             + "VALUES(?)";
     
         try (
             Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
                 JDBCUtil.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
                 Statement.RETURN_GENERATED_KEYS);) {
     
 
           
           System.out.println(preparedStatement);
     
           ResultSet rs = preparedStatement.getGeneratedKeys();
     
           if (rs.next()) {
     
             //song.setId(rs.getInt(2));
           }
     
         } catch (SQLException e) {
           System.out.println(e);
         }
         
       }
}
