package model;

public class Song extends Track {
  public Song(float duration, String name, String gender) {
    setDuration(duration);
    setName(name);
    setGender(gender);
  }

  @Override
  public String toString() {
    return "name: " + getName() +
          "\n gender: " + getGender() + 
          "\n duration of song: " + getDuration();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new Song(getDuration(), getName(), getGender());
  }
}

