package service;

import com.google.gson.Gson;
import dao.PlaylistDAO;
import model.Playlist;

import static spark.Spark.post;

public class Others {
    public static void uploadPlaylist(){
        post("/uploadPlaylist", "application/json",(req, res)->{
            return new PlaylistDAO().add( new Gson().fromJson(req.body(), Playlist.class));
        });
    }

}
