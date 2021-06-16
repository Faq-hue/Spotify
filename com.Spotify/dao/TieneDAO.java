package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.JDBCUtil;


public class TieneDAO {

  public void add(String idP, String idT) {

    String INSERT_tiene_SQL = "INSERT INTO tiene (id_playlist,id_pista)" + " VALUES (?,?);";

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_tiene_SQL);) {

      preparedStatement.setString(1, idP);
      preparedStatement.setString(2, idT);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  public List<String> getPlaylist(String idT) {

    String SELECT_tiene_Playlist_SQL = "SELECT id_playlist FROM tiene"+" WHERE id_playlist =?;";
    List<String> pl = new ArrayList<String>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_tiene_Playlist_SQL);) {

      preparedStatement.setString(1, idT);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        pl.add(rs.getString(1));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return pl;
  }
  
  public List<String> getTrack(String idP) {

    String SELECT_tiene_Track_SQL = "SELECT id_pista FROM tiene"+" WHERE id_playlist =?;";
    List<String> tr = new ArrayList<String>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_tiene_Track_SQL);) {
        
      preparedStatement.setString(1, idP);
      ResultSet rs = preparedStatement.executeQuery();
      while(rs.next()){
        tr.add(rs.getString(1));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return tr;
  }

}
