package dao.dao_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.JDBCUtil;
import dao.dao_interfaces.IConsumerDAO;
import model.Consumer;

public class ConsumerDAO implements IConsumerDAO {

  private UserDAO d = new UserDAO();
  private String INSERT_CONSUMER_SQL = "INSERT INTO spotify.consumidor (id_usuario,seguidores,seguidos)"
      + "VALUES (?,?,?);";

  private String SELECT_ONE_CONSUMER_SQL = "SELECT * FROM consumidor " + "WHERE id_usuario=?;";

  private String DELETE_ONE_CONSUMER_SQL = "DELETE FROM consumidor " + "WHERE id_usuario=?;";

  private String UPDATE_ONE_CONSUMER_SQL = "UPDATE consumidor " + "SET seguidores=?,seguidos=? WHERE id_usuario = ?;";

  private String SELECT_CONSUMER_SQL = "SELECT * FROM consumidor";

  @Override
  public Consumer add(Consumer consumer) {

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONSUMER_SQL,
            java.sql.Statement.RETURN_GENERATED_KEYS);) {

      preparedStatement.setString(1, d.add(consumer).getId());
      preparedStatement.setInt(2, consumer.getFollowers());
      preparedStatement.setInt(3, consumer.getFollowed());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return consumer;
  }

  @Override
  public Consumer get(String id) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_CONSUMER_SQL);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        return new Consumer(rs.getString(2), rs.getString(3));
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  }

  @Override
  public Consumer delete(String id) {
    Consumer c = (Consumer) d.delete(id);
    c.setFollowed(get(id).getFollowed());
    c.setFollowers(get(id).getFollowers());

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONE_CONSUMER_SQL);) {

      preparedStatement.setString(1, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return c;
  }

  @Override
  public Consumer update(String id, Consumer consumerUpdated) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_CONSUMER_SQL);) {

      preparedStatement.setInt(1, consumerUpdated.getFollowers());
      preparedStatement.setInt(2, consumerUpdated.getFollowed());
      preparedStatement.setString(4, id);

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return consumerUpdated;
  }

  @Override
  public List<Consumer> getlist() {
    List<Consumer> consumers = new ArrayList<Consumer>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONSUMER_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Consumer tmp = new Consumer(d.get(rs.getString(1)).getUserName(), d.get(rs.getString(1)).getNationality());
        tmp.setFollowers(rs.getInt(2));
        tmp.setFollowed(rs.getInt(3));
        consumers.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return consumers;
  }

  @Override
  public Consumer modFollow(String id, byte arg) {
    String MOD_FOLLOW;
    // SI ARG = 1 suma un seguidor, si es -1 resta un seguidor
    // ocurre lo mismo con los seguidos con ladiferencia de que es 2 y -2 lo que espera;
    if (arg == 1) {
      MOD_FOLLOW = "UPDATE consumidor SET seguidores=(seguidores+1) WHERE id_usuario = " + id + ";";
    } else if (arg == -1) {
      MOD_FOLLOW = "UPDATE consumidor SET seguidores=(seguidores-1) WHERE id_usuario = " + id + ";";
    } else if (arg == 2) {
      MOD_FOLLOW = "UPDATE consumidor SET seguidos=(seguidos+1) WHERE id_usuario = " + id + ";";
    } else {
      MOD_FOLLOW = "UPDATE consumidor SET seguidos=(seguidos-1) WHERE id_usuario = " + id + ";";
    }

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(MOD_FOLLOW);) {

      preparedStatement.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    }
    return get(id);
  }

}
