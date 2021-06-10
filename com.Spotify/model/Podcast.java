package model;

public class Podcast extends Track {
  private String description;

  public Podcast(String name, String gender, float duration) {
    super(name, gender, duration, 0);
    setDescription(description);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return super.toString() + "\n Description: " + getDescription();
  }

}
