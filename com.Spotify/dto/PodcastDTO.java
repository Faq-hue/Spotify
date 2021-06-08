
package dto;


public class PodcastDTO {
    private String name;
    private String gender;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public PodcastDTO(String name, String gender, String duration){
        super();
        this.name = name;
        this.gender = gender;
        this.duration = duration;
    }
    
    
}
