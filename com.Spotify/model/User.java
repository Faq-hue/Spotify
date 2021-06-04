package model;

public class User {

    private String name = new String();
    private String nacionality = new String();
    private int createdPlaylists;

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getNacionality() {
        return this.nacionality;
    }

    protected void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    protected int getCreatedPlaylists() {
        return this.createdPlaylists;
    }

    protected void setCreatedPlaylists(int createdPlaylists) {
        this.createdPlaylists = createdPlaylists;
    }



}
