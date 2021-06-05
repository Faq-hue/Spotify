package exception;

public class notFoundSongException extends Exception{
  public notFoundSongException(){}
  public notFoundSongException(String errorMessage){
    super(errorMessage);
  }
}