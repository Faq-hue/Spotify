import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Consumer;
import model.Countries;
import model.Creator;
import model.Playlist;
import model.Podcast;
import model.Song;
import model.Track;
import model.User;

public class ModelGenerator {

    static public Consumer consumerGenerator(){

        String name[] = { "Facundo", "Dario", "Santiago", "Kevin", "Thais", "Angelo", "Milagros", "Sofia", "Gabriel",
        "Enzo", "Karen", "Micaela", "Ezequiel", "Yair", "Tomas", "Britney", "Taylor", "Camila", "Joaquin",
        "Nicolas" };

        Random r = new Random();

        int x = r.nextInt(19);

        int f = r.nextInt(9999999);

        int fw = r.nextInt(9999999);

        Consumer c = new Consumer();

        c.setFollowed(f);
        c.setFollowers(fw);

        c.setUserName(name[x]);
        c.setNationality(Countries.selectCountry(r.nextInt(193) + 1));

        return c;
    }

    static public Creator creatorGeneCreator(){

        String name[] = { "Facundo", "Dario", "Santiago", "Kevin", "Thais", "Angelo", "Milagros", "Sofia", "Gabriel",
        "Enzo", "Karen", "Micaela", "Ezequiel", "Yair", "Tomas", "Britney", "Taylor", "Camila", "Joaquin",
        "Nicolas" };

        Random r = new Random();

        int x = r.nextInt(19);

        Creator c = new Creator();

        c.setUserName(name[x]);
        c.setNationality(Countries.selectCountry(r.nextInt(193) + 1));

        return c;
    }


    static public Song songGenerator(){

        String nameS [] = {"Like a Rolling Stone", "Imagine", "Welcome to the Jungle", "Groceries", "Sleeping Lowfy", "Presaure", "Histeria", "One"};

        String genS [] = {"Rock", "Rock", "Hard Rock", "Trap", "Chill", "Rock", "Rock", "Metal"};

        String letter []= {"**Weird Sound**" , "Miau", "Guau", "Bark", "uwu", "owo", "**silence**"};

        Random r = new Random();

        int x = r.nextInt(6);

        Song s = new Song();
        s.setLetter(letter[x]);

        s.setName(nameS[x]);
        s.setTipe((byte)0);
        s.setGender(genS[x]);
        s.setDuration(x);

        return s;
    }

    static public Podcast podcastGenerator(){

        String nameP []= {"Alex al habla ep1", "The wild project ep2", "EP350: Cafe algo", "Malditos gamer ep149"};

        Random r = new Random();

        int x = r.nextInt(3);

        Podcast p = new Podcast();
        p.setDescription("Blah x" + x);

        p.setName(nameP[x]);
        p.setTipe((byte)1);
        p.setGender("Podcast");
        p.setDuration(x);

        return p;
    }


    static public Playlist playlistGeneCreator(){

        List <Track> ls = new ArrayList <Track>();

        Random r = new Random();

        int x = r.nextInt(7);

        Playlist pl = new Playlist();

        pl.setNamePlaylist("Playlist loca " + x);

        for (int i = 0; i < x; i++) {
            
            //ls.add(trackSongGenerator());

        }

        pl.setPlaylistContent(ls);

        return pl;
    }
    


}
