package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.JDBCUtil;
import dao.dao_interfaces.track_interfaces.IPlaylist;
import model.Playlist;

public class PlaylistDAO implements IPlaylist {

  String INSER_PLAYLIST_SQL = "INSERT INTO playlist (id_playlist,nombre,cantidad_pistas,fecha_creacion,id_usuario)"
      + " VALUES (?,?,?,?,?);";
  String SELECT_ONE_PLAYLIST = "SELECT * FROM playlist" + " WHERE id_playlist=?;";
  String DELETE_PLAYLIST_SQL = "DELETE FROM playlist" + "WHERE id_playlist=?;";
  String SELECT_PLAYLIST_SQL = "SELECT * FROM playlist;";

  @Override
  public Playlist add(Playlist playlist) {
    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(INSER_PLAYLIST_SQL)) {

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
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_PLAYLIST)) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        p.setId(rs.getString(1));
        p.setIdUser(rs.getString(5));
        p.setNamePlaylist(rs.getString(2));
        p.setDate(rs.getString(4));

        for (int i = 0; i < rs.getInt(3); i++) {
          p.getPlaylistContent().add(new SongDAO().get(new TieneDAO().getTrackid(p.getId()).get(i)));
        }

      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }
    return p;
  }

  @Override
  public Playlist delete(String id) {
    Playlist p = get(id);
    TieneDAO t = new TieneDAO();
    t.delete(id);

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYLIST_SQL)) {

      preparedStatement.setString(1, id);

      System.out.println(preparedStatement);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }
    return p;
  }

  @Override
  public Playlist update(String id, Playlist plUpdate) {
    delete(id);
    add(plUpdate);
    return plUpdate;
  }

  @Override
  public List<Playlist> getlist() {

    List<Playlist> lPlaylist = new ArrayList<>();

    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLAYLIST_SQL)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Playlist tmp = new PlaylistDAO().get(rs.getString(1));
        tmp.setId(rs.getString(1));
        lPlaylist.add(tmp);
      }

    } catch (Exception e) {
      System.out.println(e);
    }

    return lPlaylist;
  }

}
