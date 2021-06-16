package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import config.JDBCUtil;
import dao.dao_interfaces.track_interfaces.IPlaylist;
import model.Playlist;

public class PlaylistDAO implements IPlaylist {

  String INSER_PLAYLIST_SQL = "INSERT INTO playlist (id_playlist,nombre,cantidad_pistas,fecha_creacion,id_usuario)"
      + " VALUES (?,?,?,?,?);";
  String SELECT_ONE_PLAYLIST = "SELECT * FROM playlist" + " WHERE id_playlist=?;";

  @Override
  public Playlist add(Playlist playlist) {
    try (Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
        JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSER_PLAYLIST_SQL);) {
      
      preparedStatement.setString(1, playlist.getId());
      preparedStatement.setString(2, playlist.getNamePlaylist());
      preparedStatement.setInt(3, playlist.getPlaylistContent().size());
      preparedStatement.setString(4, playlist.getDate());
      preparedStatement.setString(5, playlist.getIdUser());

      preparedStatement.executeUpdate();

      TieneDAO p = new TieneDAO();
      for (int i = 0; i < playlist.getPlaylistContent().size(); i++) {
        p.add(playlist.getId(), playlist.getPlaylistContent().get(i).getId());
      }

      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println(e);
    }

    return playlist;
  }

  @Override
  public Playlist get(String id) {
    Playlist p = new Playlist();
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_PLAYLIST);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        p.setId(rs.getString(1));
        p.setIdUser(rs.getString(5));
        p.setNamePlaylist(rs.getString(2));
        p.setDate(rs.getString(4));

        for (int i = 0; i < rs.getInt(3); i++) {
          p.getPlaylistContent().add(new SongDAO().get(new TieneDAO().getTrack(rs.getString(1)).get(i)));
        }

      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }
    return p;
  }

  @Override
  public Playlist delete(String arg) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Playlist update(String arg1, Playlist arg2) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Playlist> getlist() {
    // TODO Auto-generated method stub
    return null;
  }

}
