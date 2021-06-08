package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JDBCUtil;
import model.Podcast;

public class PodcastDAO {
    public void add(Podcast podcast) {

       String INSERT_USER_SQL = "INSERT INTO Spotify.Podcast (descripcion, Pista_idPista)"
            + "VALUES(?,?)";
    
        try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
                JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
                Statement.RETURN_GENERATED_KEYS);) {
    

          
          preparedStatement.setString(1, podcast.getDescription());
         
          System.out.println(preparedStatement);
    /* 
          ResultSet rs = preparedStatement.getGeneratedKeys();
    
          if (rs.next()) {
    
            podcast.(rs.getInt(2));
          } */
    
        } catch (SQLException e) {
          System.out.println(e);
        }
      }
}
