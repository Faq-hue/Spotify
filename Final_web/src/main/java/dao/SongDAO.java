package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.JDBCUtil;
import dao.dao_interfaces.track_interfaces.ISongDAO;
import model.Song;

public class SongDAO implements ISongDAO {

  private final TrackDAO tr = new TrackDAO();

  @Override
  public Song add(Song song) {

    String INSERT_SONG_SQL = "INSERT INTO cancion (id_pista, letra)" + "VALUES(?,?)";
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SONG_SQL)) {

      preparedStatement.setString(1, tr.add(song).getId());
      preparedStatement.setString(2, song.getLetter());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return song;

  }

  @Override
  public Song get(String id) {

    Song s = new Song();

    String SELECT_ONE_SONG_SQL = "SELECT * FROM cancion " + "WHERE id_pista=?;";
    try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_SONG_SQL)) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();

      if (rs.next()) {
        s.setName(tr.get(rs.getString(1)).getName());
        s.setGender(tr.get(rs.getString(1)).getGender());
        s.setId(rs.getString(1));
        s.setDuration(tr.get(rs.getString(1)).getDuration());
        s.setPopularity(tr.get(rs.getString(1)).getPopularity());
        s.setIdUser(tr.get(rs.getString(1)).getIdUser());
        s.setLetter(rs.getString(2));
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }

    return s;

  }

  @Override
  public Song delete(String id) {

    Song s = (Song) tr.delete(id);

    String DELETE_ONE_SONG_SQL = "DELETE FROM cancion " + "WHERE id_pista=?;";
    try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_SONG_SQL)) {

      preparedStatement.setString(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return s;
  }

  @Override
  public Song update(String id, Song songUpdated) {

    String UPDATE_ONE_SONG_SQL = "UPDATE cancion " + "SET letra=? WHERE id_pista = ?;";
    try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SONG_SQL)) {

      preparedStatement.setString(1, songUpdated.getLetter());
      preparedStatement.setString(2, songUpdated.getId());

      preparedStatement.executeUpdate();

      tr.update(id, songUpdated);

    } catch (Exception e) {
      System.out.println(e);
    }
    return songUpdated;

  }

  @Override
  public List<Song> getlist() {
    List<Song> songsList = new ArrayList<Song>();
    String SELECT_SONG_SQL = "SELECT * FROM cancion";
    try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG_SQL)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Song tmp = new Song();
        tmp.setName(tr.get(rs.getString(1)).getName());
        tmp.setGender(tr.get(rs.getString(1)).getGender());
        tmp.setDuration(tr.get(rs.getString(1)).getDuration());
        tmp.setId(rs.getString(1));
        tmp.setIdUser(tr.get(rs.getString(1)).getIdUser());
        songsList.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return songsList;
  }

}
