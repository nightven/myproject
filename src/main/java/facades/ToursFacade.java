package facades;

import dao.daoImpl.ToursDatabaseDAO;
import model.Tours;

import java.util.List;

public class ToursFacade {
    ToursDatabaseDAO toursDb = new ToursDatabaseDAO();

    public boolean createTour(Tours tours){
        return toursDb.create(tours);
    }

    public Tours getTourById(int tourId){
        return toursDb.getById(tourId);
    }

    public List<Tours> getAllTours(){
        return toursDb.getAll();
    }

    public boolean updateTour(Tours tours){
        return toursDb.update(tours);
    }

    public boolean deleteTour(Tours tours){
        return toursDb.delete(tours);
    }

    public  boolean setTourAtOrder(int tourId, int orderId){
        return toursDb.setOrderTour(orderId, tourId);
    }

    public boolean deleteTourFromOrder(int orderId){
        return toursDb.deleteOrderTours(orderId);
    }
}
