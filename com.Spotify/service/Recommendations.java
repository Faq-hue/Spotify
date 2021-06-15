package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dao.TrackDAO;
import dao.UserDAO;
import model.Track;
import model.User;
import model.Playlist;

public class Recommendations {

    public static Playlist recommendationByGender() {

        Track t = new TrackDAO().get(recomendationByPopularity().getPlaylistContent().get(0).getId());

        List <Track> trackList = new TrackDAO().getlist();

        List <Track> definitiveList = new ArrayList<Track>();

        for (int i = 0; i < trackList.size(); i++) {
            
            if( trackList.get(i).getGender().equals(t.getGender()) ){

                definitiveList.add(trackList.get(i));

            }

        }
        
        Playlist plDef = new Playlist();
        plDef.setNamePlaylist("Best gender " + t.getGender());
        plDef.setPlaylistContent(definitiveList);

        return plDef;
    }

    public static Playlist recomendationByNationality() {

        User u = new UserDAO().get(recomendationByPopularity().getPlaylistContent().get(0).getIdUser());

        List <Track> trackList = new TrackDAO().getlist();

        List <Track> definitiveList = new ArrayList<Track>();

        for (int i = 0; i < trackList.size(); i++) {
            
            if( u.getNationality().equals( new UserDAO().get(trackList.get(i).getIdUser()).getNationality()) ){

                definitiveList.add(trackList.get(i));

            }

        }

        Playlist plDef = new Playlist();
        plDef.setNamePlaylist("Best of this country " + u.getNationality());
        plDef.setPlaylistContent(definitiveList);

        return plDef;
    }

    public static Playlist recomendationByArtist() {    

        User u = new UserDAO().get(recomendationByPopularity().getPlaylistContent().get(0).getIdUser());

        List <Track> tracklist = new TrackDAO().getlist();

        List<Track> definitiveList = new ArrayList<Track>();


        for (int i = 0; i < tracklist.size(); i++) {

            if( tracklist.get(0).getIdUser().equals(recomendationByPopularity().getPlaylistContent().get(0).getIdUser()) ){

                definitiveList.add(tracklist.get(i));
                
            }

        }

        Playlist plDef = new Playlist();
        plDef.setNamePlaylist("Best Artist " + u.getUserName());
        plDef.setPlaylistContent(definitiveList);

        return plDef;
    }

    public static Playlist recomendationByPopularity() {

        List<Track> listTracks = new TrackDAO().getlist();

        Track[] arr = new Track[listTracks.size()];

        int x = 0;

        Track discount = new Track();
        discount.setPopularity(-1);
        discount.setName("discount");

        for (int i = 0; i < listTracks.size(); i++) {

            if (listTracks.get(i).getTipe() == 0) {

                arr[i] = listTracks.get(i);

            } else {

                arr[i] = discount;
                x++;
            }

        }

        Arrays.sort(arr);

        List<Track> definitiveList = new ArrayList<Track>();

        int k = 0;

        for (int i = arr.length - 1; i >= 0 + x; i--) {

            definitiveList.add(k, arr[i]);
            k++;
        }

        Playlist pl = new Playlist();
        pl.setNamePlaylist("Best of the best");
        pl.setPlaylistContent(definitiveList);

        return pl;
    }

}
