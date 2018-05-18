package dao;


import model.Fly;

import java.util.List;

public interface FlyDAO extends ItemDAO<Fly>{

    public List<Fly> getAllFlyByPeriod(String start, String end);

    public boolean setOrderFly(int orderID, int flyId);
}
