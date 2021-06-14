package service;

import dao.SongDAO;
import exception.notFoundSongException;
import model.Song;

public class Play {

  public static void playSong(String id) {

    try{
      Song sPlay = new SongDAO().get(id);

      System.out.println("Playing:..." + "\n" + sPlay.getLetter());
  
    }catch(Exception e){
      notFoundSongException error= new notFoundSongException();
      System.out.println(error.getMessage() );
    }
 
  }

}
