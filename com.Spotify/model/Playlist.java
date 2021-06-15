package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Playlist {
  private String id = UUID.randomUUID().toString();
  private String namePlaylist;
  private List<Track> playlistContent = new ArrayList<Track>();
  private String date;
  private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private String idUser;

  public Playlist() {
  }

  public Playlist(String namePlaylist) {
    setNamePlaylist(namePlaylist);
    date = dtf.format(LocalDateTime.now());
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public List<Track> getPlaylistContent() {
    return playlistContent;
  }

  public void setPlaylistContent(List<Track> playlistContent) {
    this.playlistContent = playlistContent;
  }

  public String getNamePlaylist() {
    return namePlaylist;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setNamePlaylist(String namePlaylist) {
    this.namePlaylist = namePlaylist;
  }

  @Override
  public String toString() {
    return "Name: " + getNamePlaylist() + "\nSongs:\n" + this.playlistContent ;
  }
  


}
