package model;

public class Consumer extends User{
    
    private int followers;
    private int followed;

    protected int getFollowers() {
        return this.followers;
    }

    protected void setFollowers(int followers) {
        this.followers = followers;
    }

    protected int getFollowed() {
        return this.followed;
    }

    protected void setFollowed(int followed) {
        this.followed = followed;
    }

}
