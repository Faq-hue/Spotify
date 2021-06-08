package dto;
//popularity
public class TrackDTO {
    private String popularity;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    public TrackDTO(String popularity){
        super();
        this.popularity=popularity;
    }
}
