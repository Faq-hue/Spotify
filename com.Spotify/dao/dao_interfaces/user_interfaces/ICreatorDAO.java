package dao.dao_interfaces.user_interfaces;

import dao.dao_interfaces.IDao;
import model.Creator;

public interface ICreatorDAO extends IDao<Creator> {
  public Creator modTracksCreated(String id, byte arg);
}
