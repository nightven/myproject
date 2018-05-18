package facades;

import dao.daoImpl.FlyDatabaseDAO;
import model.Fly;

import java.util.List;

public class FlyFacade {
    FlyDatabaseDAO flyDb = new FlyDatabaseDAO();

    public boolean createFly(Fly fly, String inCity, String fromCity){
        return flyDb.create(fly, inCity, fromCity);
    }

    public Fly getById(int flyId){
        return flyDb.getFlyById(flyId);
    }

    public List<Fly> getAllFly(){
        return flyDb.getAll();
    }

    public List<Fly> getAllFlyByPeriod(String start, String end){
        return flyDb.getAllFlyByPeriod(start, end);
    }

    public boolean updateFly(Fly fly, String inCity, String fromCity){
        return flyDb.update(fly, inCity, fromCity);
    }

    public boolean deleteFly(int flyId){
        return flyDb.delete(flyId);
    }

    public  boolean setFlyAtOrder(int flyId, int orderId){
        return flyDb.setOrderFly(orderId, flyId);
    }

    public boolean deleteFlyOfOrder(int orderId){
        return  flyDb.deleteOdrerFly(orderId);
    }
}

