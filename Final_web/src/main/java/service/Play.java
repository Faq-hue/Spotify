package service;

import dao.PodcastDAO;
import dao.SongDAO;
import dao.TrackDAO;
import model.Podcast;
import model.Song;
import model.Track;
import service.interfaces.IPlay;
import static spark.Spark.*;

public class Play implements IPlay{

  public static void playSong(String id) {

    Song sPlay = new SongDAO().get(id);

    sPlay.setPopularity(sPlay.getPopularity()+1);

    System.out.println("Playing:..." + "\n" + sPlay.getLetter());

    SongDAO sDAO = new SongDAO();

    sDAO.update(sPlay.getId(), sPlay);

  }
  public static void playTrack() {
    get("/play/:id", (req, res) -> {
      Track sPlay = new TrackDAO().get(req.params(":id"));
      sPlay.setPopularity(sPlay.getPopularity()+1);
      new TrackDAO().update(sPlay.getId(),sPlay);
     if(sPlay.getTipe()==0)
       return "Playing Song:...\n" + new SongDAO().get(sPlay.getId()).getLetter();
     else
       return "Playing Podcast:...\n" +new PodcastDAO().get(sPlay.getId()).getDescription();

    });

  }



}
