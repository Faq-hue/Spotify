package model;

public class Song extends Track {
  public Song(float duration, String name, String gender) {
    super(name, gender, duration, 0);
  }

 
  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new Song(getDuration(), getName(), getGender());
  }
}
