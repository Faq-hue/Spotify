package dao.dao_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import config.JDBCUtil;
import model.Consumer;

public class ConsumerDAO {

  public Consumer add(Consumer consumer) {

    UserDAO d = new UserDAO();
    d.add(consumer);

    String INSERT_CONSUMER_SQL = "INSERT INTO Spotify.Consumidor (id_usuario,seguidores,seguidos)" + "VALUES (?,?,?);";

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONSUMER_SQL,
            java.sql.Statement.RETURN_GENERATED_KEYS);) {

      // preparedStatement.setInt(1, );
      preparedStatement.setInt(2, consumer.getFollowers());
      preparedStatement.setInt(3, consumer.getFollowed());

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return consumer;
  }

}
