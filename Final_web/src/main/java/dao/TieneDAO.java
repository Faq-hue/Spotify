package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.JDBCUtil;
import model.Song;

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

  public List<String> getTrackid(String idPl) {
    String SELECT_tiene_Track_SQL = "SELECT id_pista FROM tiene" + " WHERE id_playlist =?;";
    List<String> pl = new ArrayList<String>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_tiene_Track_SQL);) {

      preparedStatement.setString(1, idPl);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        pl.add(rs.getString(1));
      }

    } catch (SQLException e) {
      System.out.println(e);
    }
    return pl;
  }

  public void delete(String idPl) {
    String DELETE_PLAYLIST_SQL = "DELETE FROM tiene" + "WHERE id_playlist=?;";
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYLIST_SQL)) {

      preparedStatement.setString(1, idPl);

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

  }

  public List<String> getList(String id) {
    List<String> ls = new ArrayList<String>();
    String SELECT_ALL_SQL = "SELECT id_pista FROM tiene" + "WHERE id_playlist=?";

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);) {
      
      preparedStatement.setString(1, id);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        ls.add(rs.getString(1));
      }

    } catch (Exception e) {
      System.out.println(e);
    }

    return ls;
  }

  public void update(String id,List<Song> lS) {
    if(getList(id).size()>lS.size()){

    }
  
  }



}
