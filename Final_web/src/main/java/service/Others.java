package service;

import com.google.gson.Gson;
import dao.PlaylistDAO;
import dao.TrackDAO;
import dao.UserDAO;
import model.Playlist;

import static spark.Spark.*;

public class Others {
    public static void uploadPlaylist(){
        post("/uploadPlaylist", "application/json",(req, res)->
                new PlaylistDAO().add( new Gson().fromJson(req.body(), Playlist.class)));
    }
    public static void getListUser(){
        get("/getListUser",(req,res)-> new UserDAO().getlist());
    }
    public static void getListTrack(){
        get("/getListUser",(req,res)-> new TrackDAO().getlist());
    }


}
