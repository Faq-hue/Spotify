package dto;
//Nombre , follows , followed
public class ConsumerDTO{

    private String name;
    private String follows;
    private String followed;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFollowed(String followed) {
        this.followed = followed;
    }
    public String getFollowed() {
        return followed;
    }
    
    public void setFollows(String follows) {
        this.follows = follows;
    }
    public String getFollows() {
        return follows;
    }

    public ConsumerDTO(String name, String follows, String followed){
        super();
        this.name = name;
        this.follows = follows;
        this.followed = followed;
    }

}