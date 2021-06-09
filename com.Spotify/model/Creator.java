package model;

public class Consumer extends User {

  private int followers = 0;
  private int followed = 0;

  public Consumer(String name, String nationality) {
    super(name, nationality);
  }

  public int getFollowers() {
    return this.followers;
  }

  public void setFollowers(int followers) {
    this.followers = followers;
  }

  public int getFollowed() {
    return this.followed;
  }

  public void setFollowed(int followed) {
    this.followed = followed;
  }



  
}
