package service;

import java.util.List;
import dao.TrackDAO;
import model.Track;


public class Search {

  public static void songSearch(String songName) {

    List<Track> trackList = new TrackDAO().getlist();

    for (int i = 0; i < trackList.size(); i++) {
      if (trackList.get(i).getName().toLowerCase().contains(songName.toLowerCase())) {

        System.out.println("(-) "+ trackList.get(i).getName());

      }

    }

  }

}
