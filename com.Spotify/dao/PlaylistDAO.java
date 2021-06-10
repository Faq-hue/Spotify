package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.JDBCUtil;
import dao.dao_interfaces.IPlaylistDAO;
import model.Playlist;
import model.Song;


public class PlaylistDAO implements IPlaylistDAO{

    List<Song> playlist = new ArrayList<>();
    
    String INSERT_PLAYLIST_SQL = "INSERT INTO spotify.playlist (idPlaylist,nombre,fecha_creacion,fecha_creacion,id_usuario)" + "VALUES(?,?,?,?,?)";
    String DELETE_PLAYLIST_SQL = "DELETE FROM playlist " + "WHERE idPista=?;";
    String SELECT_PLAYLIST_SQL = "SELECT * From spotify.playlist";
    String SELECT_ONE_PLAYLIST_SQL = "SELECT * FROM spotify.playlist " + "WHERE id_playlist=?;";

    @Override
    public List<Playlist> getlist() {
        List<Playlist> playlist = new ArrayList<>();


    try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLAYLIST_SQL);) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Playlist p = new Playlist(rs.getString(2));
        p.setIdPlaylist(rs.getString(1));
        p.setIdUser(rs.getString(5));
        p.setCreationDate(rs.getString(3));
        playlist.add(p);
      }

      rs.close();


    } catch (Exception e) {
      System.out.println(e);
    }
    return playlist;
  }

     

    @Override
    public Playlist add(Playlist playlist) {
        try (
            Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
                JDBCUtil.getPassword());
    
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLIST_SQL);) {
    

            preparedStatement.setString(1, playlist.getIdPlaylist());        
            preparedStatement.setString(2, playlist.getName());
            preparedStatement.setString(3, playlist.getCreationDate());
            preparedStatement.setString(4, playlist.getIdUser());

        
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
    
          
    
    
        } catch (Exception e) {
          System.out.println(e);
        }
        return null;
    }

    String a="SELECT id_pista,letra FROM playlist p inner join tiene t on p.id_playlist=t.id_playlist;";
    public List<Song> wewe(String id){
        List<Song> lista = new ArrayList<>();
        try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(a);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()){
        lista.add(new SongDAO().get(rs.getString(2)));
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }

        return lista;
    }

    @Override
    public Playlist get(String id) {
        try (
        Connection connection = DriverManager.getConnection(JDBCUtil.getURL(), JDBCUtil.getUser(),
            JDBCUtil.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_PLAYLIST_SQL);) {

      preparedStatement.setString(1, id);

      ResultSet rs = preparedStatement.executeQuery();
        int i=0;
      while (rs.next()) {
        Playlist p = new Playlist(rs.getString(2));
        p.setIdPlaylist(rs.getString(1));
        p.setIdUser(rs.getString(5));
        p.setCreationDate(rs.getString(3));
        if(i==0){
            
        }
        p.addList(new SongDAO().get(rs.getString(1)));
        return p;
      }

      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }
        return null;
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
    
}
