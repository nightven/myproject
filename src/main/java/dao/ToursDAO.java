package dao;



import model.Tours;


import java.sql.Date;
import java.util.List;

public interface ToursDAO extends ItemDAO<Tours>{

    public boolean setOrderTour(int orderId, int toursId);

    public boolean deleteOrderTours(int orderId);

}
