package service;

import java.util.List;
import dao.SongDAO;
import model.Song;

public class Search {

    public static void songSearch( String songName ){

        List <Song> songList = new SongDAO().getlist();

        for (int i = 0; i < songList.size(); i++) {
            
            if(songList.get(i).getName().contains(songName) ){

                System.out.println("lo encontre");

            }

        }


    }


    
}
