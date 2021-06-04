import dao.ConsumerDAO;
import model.Consumer;

public class Principal {

    public static void main(String[] args) {
        
        Consumer c = new Consumer();

        c.setFollowers(3);
        c.setFollowed(77);

        ConsumerDAO cDAO = new ConsumerDAO();

        cDAO.add(c);

    }
    
}