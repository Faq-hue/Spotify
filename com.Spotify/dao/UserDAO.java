package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JDBCUtil;
import model.User;

public class UserDAO {

  public void add(Object consumer) {

    String INSERT_USER_SQL = "INSERT INTO Spotify.Usuario (IdUsuario, nombre , nacionalidad , playlist_creadas)"
        + "VALUES(?,?,?)";

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL,
            Statement.RETURN_GENERATED_KEYS);) {

      User user = (User) consumer;
      preparedStatement.setString(2, user.getUserName());
      preparedStatement.setString(3, user.getNationality());
      preparedStatement.setInt(4, user.getPlaylistCreated().size());

      System.out.println(preparedStatement);

      ResultSet rs = preparedStatement.getGeneratedKeys();

      if (rs.next()) {

        user.setId(rs.getInt(1));

      }

    } catch (SQLException e) {
      System.out.println(e);
    }
  }

}
