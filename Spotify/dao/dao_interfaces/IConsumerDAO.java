package dao.dao_interfaces;

import java.util.List;
import model.Consumer;

public interface IConsumerDAO extends IDao<Consumer>{
  public List<Consumer> getlist();
  public Consumer modFollow(String id,byte arg);

}
