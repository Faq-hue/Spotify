package service;

import dao.SongDAO;
import model.Song;
import service.interfaces.IPlay;

public class Play implements IPlay{

  public static void playSong(String id) {

    Song sPlay = new SongDAO().get(id);

    sPlay.setPopularity(sPlay.getPopularity()+1);

    System.out.println("Playing:..." + "\n" + sPlay.getLetter());

    SongDAO sDAO = new SongDAO();

    sDAO.update(sPlay.getId(), sPlay);


  }

}
