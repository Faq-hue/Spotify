package dao.dao_interfaces;

import java.util.List;
import model.Creator;

public interface ICreatorDAO extends IDao<Creator>{
  public List<Creator> getlist();
  public Creator modTracksCreated(String id,byte arg);
}
