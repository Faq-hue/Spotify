import java.util.Scanner;
import dao.PodcastDAO;
import dao.SongDAO;
import dao.TrackDAO;
import dao.UserDAO;
import model.Playlist;
import model.Podcast;
import model.Song;
import model.User;
import service.Play;
import service.RecommendationsPodcast;
import service.RecommendationsSong;
import service.Search;

public class Principal {

  public static void main(String[] args) {
    User u = new User();
    boolean p = true;
    String tmp;
    Scanner scanner = new Scanner(System.in);
    while (p) {
      System.out.println("------------Spotify------------");
      System.out.println("|       (1)-Create User       |");
      System.out.println("|     (2)-Create playlist     |");
      System.out.println("|       (3)-Upload Song       |");
      System.out.println("|     (4)-Upload Podcast      |");
      System.out.println("|  (5)- Song Recommendations  |");
      System.out.println("| (6)- Podast Recommendations |");
      System.out.println("|          (7)-Search         |");
      System.out.println("|        (8)-Play track       |");
      System.out.println("|           (9)-exit          |");
      System.out.println("-------------------------------");

      tmp = scanner.nextLine();
      switch (tmp) {
        case "1":
          u = createUser();
          break;
        case "2":
          createPlaylist(u);
          break;
        case "3":
          uploadSong();
          break;
        case "4":
          uploadPodcast();
          break;
        case "5":
          songRecommendations();
          break;
        case "6":
          podcastRecommendations();
          break;
        case "7":
          search();
          break;
        case "8":
          playTrack();
          break;
        case "9":
          p = false;
          break;
      }
    }
    scanner.close();
  }

  public static User createUser() {

    Scanner scanner = new Scanner(System.in);
    User u = new User();
    UserDAO uDAO = new UserDAO();

    System.out.println("Set a user name");
    String us = scanner.nextLine();

    u.setUserName(us);

    System.out.println("Set a nacionality");
    us = scanner.nextLine();

    u.setNationality(us);

    uDAO.add(u);

    return u;
  }

  public static void createPlaylist(User u) {

    Scanner scanner = new Scanner(System.in);

    Playlist pl = new Playlist();
    String sn;

    pl.setIdUser(u.getId());

    System.out.println("Set name playlist");
    sn = scanner.nextLine();

    pl.setNamePlaylist(sn);

    TrackDAO dao = new TrackDAO();
    System.out.println("-------------------------------");
    for (int i = 0; i < dao.getlist().size(); i++) {
      System.out.println("(" + (i + 1) + ")" + dao.getlist().get(i));
    }
    System.out.println("-------------------------------");
    System.out.println("select 4 Tracks");
    for (int i = 0; i < 4; i++) {
      int tmp;
      tmp = scanner.nextInt();
      pl.getPlaylistContent().add(dao.getlist().get(tmp - 1));
    }

  }

  public static void uploadSong() {

    Song s = new Song();
    SongDAO sDAO = new SongDAO();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Set id user");
    String sn = scanner.nextLine();

    s.setIdUser(sn);

    System.out.println("Set a song name");
    sn = scanner.nextLine();

    s.setName(sn);

    System.out.println("Set gender");
    sn = scanner.nextLine();

    s.setGender(sn);

    System.out.println("Set letter");
    sn = scanner.nextLine();
    s.setLetter(sn);

    System.out.println("Set duration");
    Float f = scanner.nextFloat();

    s.setDuration(f);


    s.setTipe((byte) 0);

    sDAO.add(s);

  }

  public static void uploadPodcast() {

    Podcast p = new Podcast();
    PodcastDAO pDAO = new PodcastDAO();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Set id user");
    String sn = scanner.nextLine();

    p.setIdUser(sn);

    System.out.println("Set a podcast name");
    sn = scanner.nextLine();

    p.setName(sn);

    System.out.println("Set description");
    sn = scanner.nextLine();
    p.setDescription(sn);

    System.out.println("Set gender");
    sn = scanner.nextLine();
    p.setGender(sn);

    System.out.println("Set duration");
    Float f = scanner.nextFloat();
    p.setDuration(f);

    p.setTipe((byte) 1);

    pDAO.add(p);

  }

  public static void songRecommendations() {

    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByPopularity());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByNationality());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByArtist());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByGender());
    System.out.println("--------------------------------------------------------------------");

  }

  public static void podcastRecommendations() {

    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsPodcast.recommendationByPopularity());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsPodcast.recommendationByNationality());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsPodcast.recommendationByArtist());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsPodcast.recommendationByGender());
    System.out.println("--------------------------------------------------------------------");

  }

  public static void search() {

    Scanner scanner = new Scanner(System.in);
    String s;
    System.out.println("Enter search data");

    s = scanner.nextLine();

    Search.songSearch(s);

  }


  public static void playTrack() {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter id song");
    String pl = scanner.nextLine();

    Play.playSong(pl);
  }

}
