package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dao.TrackDAO;
import dao.UserDAO;
import model.Track;
import model.User;
import service.interfaces.Irecomendations;
import model.Playlist;
import static spark.Spark.*;

public class RecommendationsSong implements Irecomendations{

  public static void recommendationByGender() {

    Track t = new TrackDAO().get(recommendationByPopularity().getPlaylistContent().get(0).getId());

    List <Track> trackList = new TrackDAO().getlist();

    List <Track> definitiveList = new ArrayList<>();

    for (Track track : trackList) {
      if (track.getGender().equals(t.getGender())) {
        definitiveList.add(track);
      }
    }

    Playlist plDef = new Playlist();
    plDef.setNamePlaylist("Best gender " + t.getGender());
    plDef.setPlaylistContent(definitiveList);

    get("/songRecommendationByGender", (req, res) -> plDef);
  }

  public static void recommendationByNationality() {

    User u = new UserDAO().get(recommendationByPopularity().getPlaylistContent().get(0).getIdUser());

    List <Track> trackList = new TrackDAO().getlist();

    List <Track> definitiveList = new ArrayList<>();

    for (Track track : trackList) {
      if (u.getNationality().equals(new UserDAO().get(track.getIdUser()).getNationality())) {
        definitiveList.add(track);
      }
    }

    Playlist plDef = new Playlist();
    plDef.setNamePlaylist("Best of this country " + u.getNationality());
    plDef.setPlaylistContent(definitiveList);

    get("/songRecommendationByNationality", (req, res) -> plDef);
  }

  public static void recommendationByArtist() {

    List <Track> tracklist = new TrackDAO().getlist();

    List<Track> definitiveList = new ArrayList<>();


    for (Track track : tracklist) {
      if (track.getIdUser().equals(recommendationByPopularity().getPlaylistContent().get(0).getIdUser())) {
        definitiveList.add(track);
      }
    }

    Playlist plDef = new Playlist();
    plDef.setNamePlaylist("Best Artist " + new UserDAO().get(recommendationByPopularity().getPlaylistContent().get(0).getIdUser()).getUserName());
    plDef.setPlaylistContent(definitiveList);

    get("/songRecommendationByArtist", (req, res) -> plDef);
  }


  public static Playlist recommendationByPopularity() {

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

    List<Track> definitiveList = new ArrayList<>();

    int k = 0;

    for (int i = arr.length - 1; i >= x; i--) {
      definitiveList.add(k, arr[i]);
      k++;
    }

    Playlist pl = new Playlist();
    pl.setNamePlaylist("Best of the best");
    pl.setPlaylistContent(definitiveList);

    get("/songRecommendationByPopularity", (req, res) -> pl);

    return pl;
  }

}
