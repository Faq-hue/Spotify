package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import config.JDBCUtil;
import dao.dao_interfaces.IUserDao;
import model.User;

public class UserDAO implements IUserDao {

  private String INSERT_USER_SQL = "INSERT INTO spotify.usuario (id_usuario,nombre_usuario , playlists_creadas , nacionalidad)"
      + "VALUES(?,?,?,?)";

  private String SELECT_ONE_USER_SQL = "SELECT * FROM usuario " + "WHERE id_usuario=?;";

  private String DELETE_ONE_USER_SQL = "DELETE FROM usuario " + "WHERE id_usuario=?;";

  private String UPDATE_ONE_USER_SQL = "UPDATE usuario "
      + "Set nombre_usuario = ?,playlists_creadas=?,nacionalidad=? where id_usuario = ?;";

  private String SELECT_USER_SQL = "SELECT * FROM usuario";


  @Override
  public User add(User user) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, user.getId());        
      preparedStatement.setString(2, user.getUserName());
      preparedStatement.setInt(3, user.getPlaylistCreated().size());
      preparedStatement.setString(4, user.getNationality());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return user;
  }

  @Override
  public User get(String id) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_USER_SQL);) {

      preparedStatement.setString(1, id);

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
  public User delete(String id) {
    User u = get(id);
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_USER_SQL);) {

      preparedStatement.setString(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return u;
  }

  @Override
  public User update(String id,User userUpdated) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_USER_SQL);) {

      preparedStatement.setString(1, userUpdated.getUserName());
      preparedStatement.setInt(2, userUpdated.getPlaylistCreated().size());
      preparedStatement.setString(3, userUpdated.getNationality());
      preparedStatement.setString(4,id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return userUpdated;
  }

  @Override
  public List<User> getlist() {
    
    List<User> userList = new ArrayList<User>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        User tmp = new UserDAO().get(rs.getString(1));
        tmp.setId(rs.getString(1));
        //TODO agregar Playlist a Dao
        userList.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return userList;

  }

}
