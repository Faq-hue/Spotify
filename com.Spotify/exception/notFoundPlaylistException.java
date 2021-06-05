package exception;

public class notFoundPlaylistException extends Exception{
  public notFoundPlaylistException(){}
  public notFoundPlaylistException(String errorMessage){
    super(errorMessage);
  }
}