package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JDBCUtil;
import model.Creator;


public class CreatorDAO {

    public void add(Creator creator) {

        String INSERT_USER_SQL = "INSERT INTO Spotify.Creador (pista_creadas, IdUsuario, Playlist_IdPlaylist )"
            + "VALUES(?,?)";
    
        try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
                JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
                Statement.RETURN_GENERATED_KEYS);) {
    

          
          preparedStatement.setInt(1, creator.getPlaylistCreated().size());
          
          System.out.println(preparedStatement);
    
          ResultSet rs = preparedStatement.getGeneratedKeys();
    
          if (rs.next()) {
    
            creator.setId(rs.getInt(1));
    
          }
    
        } catch (SQLException e) {
          System.out.println(e);
        }
      }
}
