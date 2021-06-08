package dto;
//Name, gender, duration
public class SongDTO{
    private String name;
    private String gender;
    private float duration;
    public String getName() {
        return name;
    }
    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }

    public SongDTO(String name , String gender, float duration){
        super();
        this.name = name;
        this.gender = gender;
        this.duration = duration;
    }
}
