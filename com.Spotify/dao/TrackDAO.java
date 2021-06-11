package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.JDBCUtil;
import dao.dao_interfaces.ITrackDAO;
import model.Track;

public class TrackDAO implements ITrackDAO {

  private String INSERT_TRACK_SQL = "INSERT INTO pista (id_pista, nombre, duracion, popularidad, genero, id_usuario)" + "VALUES(?,?,?,?,?,?)";

  private String SELECT_ONE_TRACK_SQL = "SELECT * FROM pista " + "WHERE id_pista=?;";

  private String DELETE_ONE_TRACK_SQL = "DELETE FROM pista " + "WHERE id_pista=?;";

  private String UPDATE_ONE_TRACK_SQL = "UPDATE pista "
      + "Set nombre = ?, duracion=?, popularidad=? where id_pista = ?;";

  private String SELECT_TRACK_SQL = "SELECT * FROM pista";

  @Override
  public Track add(Track track) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRACK_SQL)) {
      
      preparedStatement.setString(1, track.getId());
      preparedStatement.setString(2, track.getName());
      preparedStatement.setFloat(3, track.getDuration());
      preparedStatement.setInt(4, track.getPopularity());
      preparedStatement.setString(5, track.getGender());
      preparedStatement.setString(6, track.getIdUser());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return track;
  }

  @Override
  public Track get(String id) {
    Track t =  new Track();
      try (
          Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
              JDBCUtil.getPassword());
          PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_TRACK_SQL)) {
  
        preparedStatement.setString(1, id);
  
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
          t.setId(rs.getString(1));
          t.setName(rs.getString(2));
          t.setDuration(rs.getFloat(3));
          t.setPopularity(rs.getInt(4));
          t.setGender(rs.getString(5));
          t.setIdUser(rs.getString(6));
        }
        rs.close();
  
      } catch (SQLException e) {
        System.out.println(e);
      }
  
      return t;
    }

  @Override
  public Track delete(String id) {

    Track t = get(id);

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_TRACK_SQL)) {
      
        preparedStatement.setString(1, id);

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return t;
  }

  @Override
  public Track update(String id, Track trackUpdated) {
    
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_TRACK_SQL);) {

      preparedStatement.setString(1,trackUpdated.getName());
      preparedStatement.setFloat(2, trackUpdated.getDuration());
      preparedStatement.setInt(3, trackUpdated.getPopularity());
      preparedStatement.setString(4, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return trackUpdated;
  }

  @Override
  public List<Track> getlist() {
    
    List<Track> trackList = new ArrayList<Track>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRACK_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Track tmp = new TrackDAO().get(rs.getString(1));
        tmp.setId(rs.getString(1));
        tmp.setIdUser(rs.getString(6));
        trackList.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return trackList;
  }

}
