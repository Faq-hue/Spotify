package model;

public class Creator extends User {

  private int createdTracks;

  public Creator(){}

  public Creator(String name, String nationality) {

    super(name, nationality);

  }

  public int getCreatedTracks() {
    return this.createdTracks;
  }

  public void setCreatedTracks(int createdTracks) {
    this.createdTracks = createdTracks;
  }

}
