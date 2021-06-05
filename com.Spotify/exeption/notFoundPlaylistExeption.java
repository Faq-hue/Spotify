package exeption;

public class notFoundPlaylistExeption extends Exception{
  public notFoundPlaylistExeption(){}
  public notFoundPlaylistExeption(String errorMessage){
    super(errorMessage);
  }
}
