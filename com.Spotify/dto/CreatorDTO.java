package dto;
//Nombre , pista_creadas
public class CreatorDTO {

    private String name;
    private String playlist_created;

    public String getName() {
        return name;
    }
    public String getPlaylist_created() {
        return playlist_created;
    }
    public void setPlaylist_created(String playlist_created) {
        this.playlist_created = playlist_created;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CreatorDTO(String name, String playlist_created){
        super();
        this.name = name;
        this.playlist_created = playlist_created;
    }
    
}
