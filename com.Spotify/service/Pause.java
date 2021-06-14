package service;

import dao.SongDAO;
import dao.UserDAO;
import model.Song;
import model.User;

public class Pause {

    public static void pauseSong(String id){

        Song sPause = new SongDAO().get(id);

            System.out.println("||Is stopped||");

        User uPause = new UserDAO().get(id);

            System.out.println("User is AFK...");


    }
    
}
