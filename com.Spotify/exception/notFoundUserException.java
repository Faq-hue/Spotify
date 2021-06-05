package exception;

public class notFoundUserException extends Exception{
  public notFoundUserException(){}
  public notFoundUserException(String errorMessage){
    super(errorMessage);
  }
}