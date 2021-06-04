package model;

class Track {
  private String name;
  private float duration;
  private int popularity;
  private String gender;

  protected Track(String name, String gender, float duration, int popularity) {
    setDuration(duration);
    setGender(gender);
    setName(name);
    setPopularity(popularity);
  }

  protected String getGender() {
    return gender;
  }

  protected float getDuration() {
    return duration;
  }

  protected void setDuration(float duration) {
    this.duration = duration;
  }

  protected String getName() {
    return name;
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected int getPopularity() {
    return popularity;
  }

  protected void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  protected void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "name: " + getName() + "\n gender: " + getGender() + "\n duration of song: " + getDuration();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new Track(getName() ,getGender(), getDuration(), getPopularity());
  }
}
