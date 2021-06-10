package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.JDBCUtil;
import dao.dao_interfaces.IPodcastDAO;
import model.Podcast;

public class PodcastDAO implements IPodcastDAO {

  private String INSERT_PODCAST_SQL = "INSERT INTO podcast (id_pista,descripcion)" + "VALUES(?,?)";

  private String SELECT_ONE_PODCAST_SQL = "SELECT * FROM podcast " + "WHERE id_pista=?;";

  private String DELETE_ONE_PODCAST_SQL = "DELETE FROM podcast " + "WHERE id_pista=?;";

  private String UPDATE_ONE_PODCAST_SQL = "UPDATE podcast " + "SET descripcion=? WHERE id_pista = ?;";

  private String SELECT_PODCAST_SQL = "SELECT * FROM podcast";

  private TrackDAO tr = new TrackDAO();

  @Override
  public Podcast add(Podcast podcast) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PODCAST_SQL,
            java.sql.Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, tr.add(podcast).getId());
      preparedStatement.setString(2, podcast.getDescription());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return podcast;
  }

  @Override
  public Podcast get(String id) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_PODCAST_SQL);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        return new Podcast(rs.getString(1), rs.getString(2), rs.getFloat(3));
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  }

  @Override
  public Podcast delete(String id) {

    Podcast s = (Podcast) tr.delete(id);

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_PODCAST_SQL);) {

      preparedStatement.setString(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return s;

  }

  @Override
  public Podcast update(String id, Podcast podcastUpdated) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_PODCAST_SQL);) {

      preparedStatement.setString(1, podcastUpdated.getDescription());

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return podcastUpdated;

  }

  @Override
  public List<Podcast> getlist() {
    
    List<Podcast> songsList = new ArrayList<Podcast>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PODCAST_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Podcast tmp = new Podcast(tr.get(rs.getString(1)).getName(), tr.get(rs.getString(1)).getGender(), tr.get(rs.getString(1)).getDuration());
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
