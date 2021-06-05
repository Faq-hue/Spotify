package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.JDBCUtil;
import model.Consumer;

public class ConsumerDAO {
    
    public Consumer add ( Consumer consumer ){

        String INSERT_CONSUMER_SQL = "INSERT INTO Spotify.Consumidor (seguidores, seguidos, Usuario_idUsuario)" + "VALUES (?,?,?);";

        

        try {
            
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(), JDBCUtil.getPassword());

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONSUMER_SQL);            
            preparedStatement.setInt(1, consumer.getFollowers());
            preparedStatement.setInt(2, consumer.getFollowed());
            preparedStatement.setInt(3, 150);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

            //ResultSet rs = preparedStatement.getGeneratedKeys();

            //if(rs.next()){
              //  consumer.setId(rs.getInt(1));
            //}

        } catch (SQLException e) {
            System.out.println(e);
        }

        return consumer;
    }

}
