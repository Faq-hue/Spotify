package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.JDBCUtil;
import dao.dao_interfaces.ISongDAO;
import model.Song;

public class SongDAO implements ISongDAO {

  private String INSERT_SONG_SQL = "INSERT INTO cancion (nombre, duracion, popularidad, genero)" + "VALUES(?,?,?,?)";

  @Override
  public Song add(Song arg) {

    return null;
  }

  @Override
  public Song get(int arg) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Song delete(int arg) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Song update(int arg1, Song arg2) {
    // TODO Auto-generated method stub
    return null;
  }
}
