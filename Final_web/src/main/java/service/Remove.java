package service;

import dao.PlaylistDAO;
import dao.TrackDAO;
import dao.UserDAO;


import static spark.Spark.*;

public class Remove {
    public static void removeUser(){
        delete("/deleteUser/:id",(req,res)->new UserDAO().delete(req.params(":id")));
    }
    public static void removeTrack(){
        delete("/deleteTrack/:id",(req,res)->new TrackDAO().delete(req.params(":id")));
    }
    public static void removePlayList(){ delete("/deletePlaylist/:id",(req,res)->new PlaylistDAO().delete(req.params(":id"))); }

}
