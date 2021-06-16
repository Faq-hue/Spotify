import java.util.Random;

import dao.ConsumerDAO;
import dao.CreatorDAO;
import dao.PodcastDAO;
import dao.SongDAO;
import model.Consumer;
import model.Creator;
import model.Podcast;
import model.Song;

public class Test {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        ConsumerDAO con = new ConsumerDAO();

        for (int i = 1; i <= 10; i++) {

            Consumer consumer = ModelGenerator.consumerGenerator();
            consumer.setId(i+"");

            con.add(consumer);
        }
        
        CreatorDAO cr = new CreatorDAO();

        for (int i = 11; i <= 15; i++) {

            Creator creator = ModelGenerator.creatorGeneCreator();
            creator.setId((i)+"");

            cr.add(creator);
        }

        SongDAO s = new SongDAO();

        for (int i = 1; i <= 10; i++) {
            
            int x = r.nextInt(15)+11;

            Song song = ModelGenerator.songGenerator();
            song.setId(i+"");
            song.setIdUser((x)+"");

            s.add(song);
        }

        PodcastDAO p = new PodcastDAO();

        for (int i = 11; i <= 15; i++) {

            int x = r.nextInt(15)+11;

            Podcast podcast = ModelGenerator.podcastGenerator();
            podcast.setId((i)+"");
            podcast.setIdUser((x)+"");

            p.add(podcast);
        }

    }
}
