package model;

public class Song extends Track {

  String letter = new String();

  public Song(){}
  
  public Song(float duration, String name, String gender) {
    super(name, gender, duration, 0);
  }
  
  public String getLetter() {
    return this.letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }


  @Override
  public String toString() {
    return super.toString();
  }
}
