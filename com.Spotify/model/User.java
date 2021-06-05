package model;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String userName;
  private String nationality;
  private List<Playlist> playlistCreated = new ArrayList<Playlist>();

  protected User(String name, String nationality, List<Playlist> playlistCreated) {
    this(name, nationality);
    setPlaylistCreated(playlistCreated);
  }

  protected User(String name, String nationality, Playlist... playlistCreated) {
    this(name, nationality);
    for (Playlist playlist : playlistCreated)
      this.playlistCreated.add(playlist);

  }

  protected User (String name, String nationality) {
    setNationality(nationality);
    setUserName(userName);
  }

  protected List<Playlist> getPlaylistCreated() {
    return playlistCreated;
  }

  protected String getNationality() {
    return nationality;
  }

  protected void setNationality(String nationality) {
    this.nationality = nationality;
  }

  protected String getUserName() {
    return userName;
  }

  protected void setUserName(String userName) {
    this.userName = userName;
  }

  protected void setPlaylistCreated(List<Playlist> playlistCreated) {
    this.playlistCreated = playlistCreated;
  }

  @Override
  public String toString() {
    return "User name: " + getUserName() + "\n User Nationality: " + getNationality() + "\n Playlist created: "
        + getPlaylistCreated().size();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new User(getUserName(), getNationality(), getPlaylistCreated());
  }

}
