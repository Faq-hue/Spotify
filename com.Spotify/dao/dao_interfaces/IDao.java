package dao.dao_interfaces;

public interface IDao<T> {
  public T add(T arg);

  public T get(String arg);

  public T delete(String arg);

  public T update(String arg1,T arg2);
}
