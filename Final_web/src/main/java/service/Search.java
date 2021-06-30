package service;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

import model.Track;
import service.interfaces.ISearch;
import dao.TrackDAO;

public class Search implements ISearch {

    public static void songSearch(String songName) {

        List<Track> trackList = new TrackDAO().getlist();

        for (Track track : trackList) {
            if (track.getTipe() == 0){
                if (track.getName().toLowerCase().contains(songName.toLowerCase())) {
                    System.out.println("(-) " + track.getName());
                }
            }
        }

    }
    public static void songSearch(){
        get("/search/:name",(req,res)->{
            List<Track> trackList = new TrackDAO().getlist();
            List<Track> tmp = new ArrayList<>();
            for (Track track : trackList) {
                if (track.getName().toLowerCase().contains(req.params(":name").toLowerCase()))
                    tmp.add(track);
            }
            return tmp;
        });
    }


}
