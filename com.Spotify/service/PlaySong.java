package service;

import dao.SongDAO;
import model.Song;

public class PlaySong {
  public void play(String id){
    Song s = new SongDAO().get(id);
    System.out.println("Duration:"+s.getDuration()+"\nName:"+s.getName());
  }
}
