import javax.sound.midi.Track;

import dao.ConsumerDAO;
import dao.CreatorDAO;
import dao.SongDAO;
import dao.TrackDAO;
import model.Consumer;
import model.Creator;
import model.Song;
import model.User;
import service.PlaySong;

public class Principal {

  public static void main(String[] args) {
    
    
    TrackDAO tr = new TrackDAO();

    System.out.println(tr.get("b19da0fc-0fd5-4830-8aef-b841ef4e99bb"));

  }

}