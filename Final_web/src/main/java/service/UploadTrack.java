package service;

import com.google.gson.Gson;
import dao.PodcastDAO;
import dao.SongDAO;
import model.Podcast;
import model.Song;

import static spark.Spark.*;

public class UploadTrack {
    public static void uploadSong() {
        post("/uploadSong", "application/json", (req, res) -> {
            return new SongDAO().add(new Gson().fromJson(req.body(), Song.class));
        });
    }

    public static void uploadPodcast() {
        post("/uploadPodcast", "application/json", (req, res) -> {
            return new PodcastDAO().add(new Gson().fromJson(req.body(), Podcast.class));
        });
    }

    public static void updateSong(){
        post("/updateSong", "application/json", (req, res) -> {
            Song s = new Gson().fromJson(req.body(), Song.class);
            return new SongDAO().update(s.getId(),s);
        });
    }
    public static void updatePodcast(){
        post("/updatePodcast", "application/json", (req, res) -> {
            Podcast p = new Gson().fromJson(req.body(), Podcast.class);
            return new PodcastDAO().update(p.getId(),p);
        });
    }
}
