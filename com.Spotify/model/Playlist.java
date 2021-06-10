package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Playlist {
    private String idPlaylist = UUID.randomUUID().toString();
    private String idUser;
    private String name;
    private List<Track> lista = new ArrayList<>();
    private String creationDate;

    public Playlist (String name){
        this.name = name;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public List<Track> getLista() {
        return lista;
    }
    public void setLista(List<Track> lista) {
        this.lista = lista;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    public void addList(Track track){
        lista.add(track);
    }
    public void removeList(Track track){
        lista.remove(track);
    }
}
