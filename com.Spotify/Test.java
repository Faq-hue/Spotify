import dao.ConsumerDAO;
import dao.CreatorDAO;
import dao.PodcastDAO;
import dao.SongDAO;
import dao.TrackDAO;
import dao.UserDAO;
import model.Consumer;
import model.Creator;
import model.Podcast;
import model.Song;
import model.Track;
import model.User;

public class Test {

    public static void main(String[] args) {
        
        
        ConsumerDAO con = new ConsumerDAO();

        for (int i = 0; i < 10; i++) {

            Consumer consumer = ModelGenerator.consumerGenerator();
            consumer.setId(i+"");

            con.add(consumer);
        }
        
        CreatorDAO cr = new CreatorDAO();

        for (int i = 0; i < 5; i++) {

            Creator creator = ModelGenerator.creatorGeneCreator();
            creator.setId((i+10)+"");

            cr.add(creator);
        }

        SongDAO s = new SongDAO();

        for (int i = 0; i < 7; i++) {

            Song song = ModelGenerator.songGenerator();
            song.setId(i+"");
            song.setIdUser((i+10)+"");

            s.add(song);
        }

        PodcastDAO p = new PodcastDAO();

        for (int i = 0; i < 3; i++) {

            Podcast podcast = ModelGenerator.podcastGenerator();
            podcast.setId((i+7)+"");
            podcast.setIdUser((i+10)+"");

            p.add(podcast);
        }

    }

    




    
}
