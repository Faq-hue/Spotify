package exeption;

public class notFoundSongExeption extends Exception{
  public notFoundSongExeption(){}
  public notFoundSongExeption(String errorMessage){
    super(errorMessage);
  }
}
