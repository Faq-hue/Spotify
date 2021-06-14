package dao.dao_interfaces.user_interfaces;

import dao.dao_interfaces.IDao;
import model.Consumer;

public interface IConsumerDAO extends IDao<Consumer>{
  public Consumer modFollow(String id,byte arg);

}
