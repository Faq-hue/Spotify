package service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import dao.PlaylistDAO;
import dao.SongDAO;
import model.Song;
import model.Track;
import model.Playlist;

public class Recommendations  {

    public Playlist recommendationByCountry(){

        PlaylistDAO plDAO = new PlaylistDAO();
        SongDAO sDAO = new SongDAO();

        List<Song> listSongs = sDAO.getlist();        

        return new Playlist();
    }

    public Playlist recomendationByGender(){

        return new Playlist();
    }

    public Playlist recomendationByArtist(){

        return new Playlist();
    }

    public Playlist recomendationByPopularity(){

        Playlist pl = new Playlist();

        PlaylistDAO plDAO = new PlaylistDAO();
        
        List<Song> listSongs = new SongDAO().getlist();

        Song [] arr = new Song[listSongs.size()];

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            
            System.out.println(arr[i]);

        }
        

        return new Playlist();
    }
    
}
