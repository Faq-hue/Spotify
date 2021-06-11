package service;

import dao.SongDAO;
import model.Song;

public class Play {
    
    public static void playSong( String id ){

        SongDAO sDAO = new SongDAO();

        Song sPlay = sDAO.get(id);        

        System.out.println("Playing:..." + "\n" + sPlay.getLetter());

    }

}
