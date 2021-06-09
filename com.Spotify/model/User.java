package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
  private String id = UUID.randomUUID().toString();
  private String userName;
  private String nationality;
  private List<Playlist> playlistCreated = new ArrayList<Playlist>();

  protected User(String name, String nationality, List<Playlist> playlistCreated) {
    this(name, nationality);
    setPlaylistCreated(playlistCreated);
  }

  public User(String name, String nationality) {
    setNationality(nationality);
    setUserName(name);
  }

  public List<Playlist> getPlaylistCreated() {
    return playlistCreated;
  }

  public String getNationality() {
    return nationality;
  }

  protected void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getUserName() {
    return userName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  protected void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPlaylistCreated(List<Playlist> playlistCreated) {
    this.playlistCreated = playlistCreated;
  }

  @Override
  public String toString() {
    return "User name: " + getUserName() + "\n User Nationality: " + getNationality() + "\n Playlist created: "
        + getPlaylistCreated().size();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return new User(getUserName(), getNationality(), getPlaylistCreated());
  }

}
