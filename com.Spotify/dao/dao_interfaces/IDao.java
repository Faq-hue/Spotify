package dao.dao_interfaces;

import java.util.List;

public interface IDao<T> {
  public T add(T arg);

  public T get(String arg);

  public T delete(String arg);

  public T update(String arg1,T arg2);

  public List<T> getlist();
}
