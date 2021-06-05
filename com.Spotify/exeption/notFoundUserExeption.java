package exeption;

public class notFoundUserExeption extends Exception{
  public notFoundUserExeption(){}
  public notFoundUserExeption(String errorMessage){
    super(errorMessage);
  }
}
