package dao.dao_interfaces;

public interface IDao<T> {
  public T add(T arg);

  public T get(int arg);

  public T delete(int arg);

  public T update(int arg1,T arg2);
}
