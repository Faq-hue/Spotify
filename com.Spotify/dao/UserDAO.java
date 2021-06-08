package dao.dao_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JDBCUtil;
import dao.dao_interfaces.IUserDao;
import model.User;

public class UserDAO implements IUserDao {

  private String INSERT_USER_SQL = "INSERT INTO spotify.usuario (nombre_usuario , playlists_creadas , nacionalidad)"
      + "VALUES(?,?,?)";

  private String SELECT_ONE_USER_SQL = "SELECT * FROM usuario " + "WHERE id_usuario=?;";

  private String DELETE_ONE_USER_SQL = "DELETE FROM usuario " + "WHERE id_usuario=?;";

  private String UPDATE_ONE_USER_SQL = "UPDATE usuario "
      + "Set nombre_usuario = ?,playlists_creadas=?,nacionalidad=? where id_usuario = ?;";

  @Override
  public User add(User user) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, user.getUserName());
      preparedStatement.setInt(2, user.getPlaylistCreated().size());
      preparedStatement.setString(3, user.getNationality());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return user;
  }

  @Override
  public User get(int id) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_USER_SQL);) {

      preparedStatement.setInt(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        return new User(rs.getString(2), rs.getString(4));
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  }

  @Override
  public User delete(int id) {
    User u = get(id);
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_USER_SQL);) {

      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return u;
  }

  @Override
  public User update(int id,User userUpdated) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_USER_SQL);) {

      preparedStatement.setString(1, userUpdated.getUserName());
      preparedStatement.setInt(2, userUpdated.getPlaylistCreated().size());
      preparedStatement.setString(3, userUpdated.getNationality());
      preparedStatement.setInt(4,id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return userUpdated;
  }

}
