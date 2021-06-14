package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


import dao.PlaylistDAO;
import dao.SongDAO;
import dao.TrackDAO;
import model.Song;
import model.Track;
import model.Playlist;

public class Recommendations  {

    public Playlist recommendationByCountry(){

        List<Track> listTracks = new TrackDAO().getlist();

        List<Song> listSongs = new SongDAO().getlist();

        Track[] arr = new Track[listSongs.size()];

        for (int i = 0; i < listTracks.size(); i++) {

            try {
                if (listSongs.get(i) != null) {

                    arr[i] = listTracks.get(i);

                }
            } catch (Exception e) {

            }

        }

        Arrays.sort(arr);

        for (int i = arr.length; i == arr.length || i > 0; i--) {

            System.out.println(arr[i - 1]);

        }    

        return new Playlist();
    }
    

    public Playlist recomendationByGender(){
        List<Track> listTracks = new TrackDAO().getlist();

        List<Song> listSongs = new SongDAO().getlist();

        Track[] arr = new Track[listSongs.size()];

        for (int i = 0; i < listTracks.size(); i++) {

            try {
                if (listSongs.get(i) != null) {

                    arr[i] = listTracks.get(i);

                }
            } catch (Exception e) {

            }

        }

        Arrays.sort(arr);

        for (int i = arr.length; i == arr.length || i > 0; i--) {

            System.out.println(arr[i - 1]);

        }
        
        return new Playlist();
    }


    public Playlist recomendationByArtist(){

      
        List<Track> listTracks = new TrackDAO().getlist();

        List<Song> listSongs = new SongDAO().getlist();

        Track[] arr = new Track[listSongs.size()];

        for (int i = 0; i < listTracks.size(); i++) {

            try {
                if (listSongs.get(i) != null) {

                    arr[i] = listTracks.get(i);

                }
            } catch (Exception e) {

            }

        }

        Arrays.sort(arr);

        for (int i = arr.length; i == arr.length || i > 0; i--) {

            System.out.println(arr[i - 1]);

        }
        
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
