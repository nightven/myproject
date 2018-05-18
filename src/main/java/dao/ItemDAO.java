package dao;



import model.Model;

import java.util.List;

public interface ItemDAO <T extends Model> {
    //create
    public boolean create(T model);
    //read
    public T getById(int id);

    public List<T> getAll();
    //update
    public boolean update(T model);
    //delete
    public boolean delete(T model);
}
