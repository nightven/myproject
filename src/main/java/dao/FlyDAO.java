package dao;


import model.Fly;

import java.util.List;

public interface FlyDAO{

    public boolean create(Fly fly, String inCity, String fromCity);

    public Fly getFlyById(int fly_id);

    public List<Fly> getAll();

    public boolean update(Fly fly,String inCity, String fromCity);

    public boolean delete(int flyID);

    public List<Fly> getAllFlyByPeriod(String start, String end);

    public boolean setOrderFly(int orderID, int flyId);

    public  boolean deleteOdrerFly(int orderId);
}
