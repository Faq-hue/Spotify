package model;

public class Song extends Track {
  
  String letter = new String();

  public String getLetter() {
    return this.letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }
  
  public Song(float duration, String name, String gender) {
    super(name, gender, duration, 0);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
