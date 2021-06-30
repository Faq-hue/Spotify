package service;

import java.util.List;

import static spark.Spark.*;

import model.Track;
import service.interfaces.ISearch;
import dao.TrackDAO;

public class Search implements ISearch {

    public static void songSearch(String songName) {

        List<Track> trackList = new TrackDAO().getlist();

        for (Track track : trackList) {
            if (track.getName().toLowerCase().contains(songName.toLowerCase())) {
                System.out.println("(-) " + track.getName());
            }
        }

        get("/search", (req, res) -> trackList);

    }

}
