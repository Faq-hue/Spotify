import dao.ConsumerDAO;
import model.Consumer;
import model.User;

public class Principal {

    public static void main(String[] args) {
        
        Consumer c = new Consumer("angie", "bolivia");

        c.setFollowers(3);
        c.setFollowed(77);
        
        ConsumerDAO cDAO = new ConsumerDAO();

        Consumer resultado = cDAO.add(c);
        
        if(resultado == null){
            System.out.println("Error");
        }

        //User u = new User("kevin", "peru");

    }
    
}