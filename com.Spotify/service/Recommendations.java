package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.mysql.cj.x.protobuf.MysqlxExpr.Object;
import dao.PlaylistDAO;
import dao.SongDAO;
import dao.TrackDAO;
import dao.UserDAO;
import model.Song;
import model.Track;
import model.User;
import model.Playlist;

public class Recommendations {

    public Playlist recommendationByCountry() {

        return new Playlist();
    }

    public static Playlist recomendationByGender() {

        List<Track> trackList = new TrackDAO().getlist();

        List<Track> genderList = new ArrayList<Track>();

        return new Playlist();
    }

    public static Playlist recomendationByArtist() {

        Playlist pl = recomendationByPopularity();

        Track t = pl.getPlaylistContent().get(0);

        User u = new UserDAO().get(t.getIdUser());

        List <Track> tracklist = new TrackDAO().getlist();

        List<Track> definitiveList = new ArrayList<Track>();


        for (int i = 0; i < tracklist.size(); i++) {

            if( tracklist.get(0).getIdUser().equals(t.getIdUser()) ){

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
