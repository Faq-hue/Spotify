package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.dao_interfaces.ICreatorDAO;
import java.util.ArrayList;
import java.util.List;
import config.JDBCUtil;
import model.Creator;

public class CreatorDAO implements ICreatorDAO {

  private UserDAO d = new UserDAO();

  String INSERT_USER_SQL = "INSERT INTO spotify.creador (id_usuario,pistas_creadas)" + "VALUES(?,?)";

  String SELECT_ONE_CREATOR_SQL = "SELECT * FROM creador " + "WHERE id_usuario=?;";

  private String DELETE_ONE_CREATOR_SQL = "DELETE FROM creador " + "WHERE id_usuario=?;";

  private String UPDATE_ONE_CREATOR_SQL = "UPDATE consumidor " + "SET pistas_creadas=? WHERE id_usuario = ?;";

  private String SELECT_CREATOR_SQL = "SELECT * FROM creador";

  @Override
  public Creator add(Creator creator) {
    d.add(creator);
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, creator.getId());
      preparedStatement.setInt(2, creator.getCreatedTracks());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }
    return creator;
  }

  @Override
  public Creator get(String id) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_CREATOR_SQL);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Creator c = new Creator(d.get(id).getUserName(), d.get(id).getNationality());
        c.setId(rs.getString(1));
        c.setCreatedTracks(rs.getInt(2));
        return c;
      }
      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public Creator delete(String id) {
    Creator c = (Creator) d.delete(id);
    c.setCreatedTracks(get(id).getCreatedTracks());

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_CREATOR_SQL);) {

      preparedStatement.setString(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return c;
  }

  @Override
  public Creator update(String id, Creator creatorUpdated) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_CREATOR_SQL);) {

      preparedStatement.setInt(1, creatorUpdated.getCreatedTracks());
      preparedStatement.setString(2, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return creatorUpdated;
  }

  @Override
  public List<Creator> getlist() {
    List<Creator> concreators = new ArrayList<Creator>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CREATOR_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Creator tmp = new Creator(d.get(rs.getString(1)).getUserName(), d.get(rs.getString(1)).getNationality());
        tmp.setId(rs.getString(1));
        tmp.setCreatedTracks(rs.getInt(2));
        concreators.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return concreators;
  }

  @Override
  public Creator modTracksCreated(String id, byte arg) {
    String UPDATE_ONE_CREATOR_SQL;
    if (arg == 1)
      UPDATE_ONE_CREATOR_SQL = "UPDATE consumidor " + "SET pistas_creadas=(pistas_creadas+1)WHERE id_usuario = ?;";
    else
      UPDATE_ONE_CREATOR_SQL = "UPDATE consumidor " + "SET pistas_creadas=(pistas_creadas-1)WHERE id_usuario = ?;";
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_CREATOR_SQL);) {
      preparedStatement.setString(2, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return get(id);
  }
}
