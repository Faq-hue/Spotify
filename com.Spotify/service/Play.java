package service;

import dao.trackdao.SongDAO;
import model.Song;

public class Play {

  public static void playSong(String id) {

    Song sPlay = new SongDAO().get(id);

    System.out.println("Playing:..." + "\n" + sPlay.getLetter());

  }

}
