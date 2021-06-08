package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import config.JDBCUtil;
import dao.dao_interfaces.ITrackDAO;
import model.Track;

public class TrackDAO implements ITrackDAO {

  private String INSERT_TRACK_SQL = "INSERT INTO pista (nombre, duracion, popularidad, genero, id_usuario)" + "VALUES(?,?,?,?,?)";

  private String SELECT_ONE_TRACK_SQL = "SELECT * FROM pista " + "WHERE id_pista=?;";

  private String DELETE_ONE_TRACK_SQL = "DELETE FROM pista " + "WHERE id_pista=?;";

  private String UPDATE_ONE_TRACK_SQL = "UPDATE pista "
      + "Set nombre = ?, duracion=?, popularidad=? where id_pista = ?;";

  @Override
  public Track add(Track track) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRACK_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, track.getName());
      preparedStatement.setFloat(2, track.getDuration());
      preparedStatement.setInt(3, track.getPopularity());
      preparedStatement.setString(4, track.getGender());
      preparedStatement.setString(5, track.getIdUser());

      System.out.println(preparedStatement);

    } catch (SQLException e) {
      System.out.println(e);
    }

    return track;
  }

  @Override
  public Track get(int id) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_TRACK_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      System.out.println(preparedStatement);

    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }

  @Override
  public Track delete(int id) {

    Track t = get(id);

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_TRACK_SQL,
            Statement.RETURN_GENERATED_KEYS);) {
      
        preparedStatement.setInt(1, id);

      System.out.println(preparedStatement);

    } catch (SQLException e) {
      System.out.println(e);
    }

    return t;
  }

  @Override
  public Track update(int id, Track trackUpdated) {
    
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_TRACK_SQL);) {

      preparedStatement.setString(1,trackUpdated.getName());
      preparedStatement.setFloat(2, trackUpdated.getDuration());
      preparedStatement.setInt(3, trackUpdated.getPopularity());
      preparedStatement.setInt(4, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return trackUpdated;
  }

}
