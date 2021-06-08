package model;

import java.util.UUID;

public class Track {
  private String id = UUID.randomUUID().toString();
  private String name;
  private float duration;
  private int popularity;
  private String gender;
  private String idUser;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdUser() {
    return this.idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public Track(String name, String gender, float duration, int popularity) {
    setDuration(duration);
    setGender(gender);
    setName(name);
    setPopularity(popularity);
  }

  public String getGender() {
    return gender;
  }

  public float getDuration() {
    return duration;
  }

  public void setDuration(float duration) {
    this.duration = duration;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "name: " + getName() + "\n gender: " + getGender() + "\n duration of song: " + getDuration();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new Track(getName(), getGender(), getDuration(), getPopularity());
  }
}
