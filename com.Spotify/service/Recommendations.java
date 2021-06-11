package service;

import java.util.List;

import dao.PlaylistDAO;
import dao.SongDAO;
import model.Song;
import model.Playlist;

public class Recommendations {

    public Playlist recommendationPlaylistSong(){

        PlaylistDAO plDAO = new PlaylistDAO();
        SongDAO sDAO = new SongDAO();

        List<Song> listSongs = sDAO.getlist();
        
        

        return new Playlist();
    }


    
}
