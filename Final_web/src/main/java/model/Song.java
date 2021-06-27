package model;

public class Song extends Track {
  
  String letter;
  
  public Song (){}

  public Song(String name, String gender,float duration) {
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
