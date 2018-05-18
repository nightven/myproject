package facades;

import dao.daoImpl.HotelDatabaseDAO;
import model.Hotel;

import java.util.List;

public class HotelFacade {
    HotelDatabaseDAO  hotelDb = new HotelDatabaseDAO();

    public boolean createHotel(Hotel hotel){
        return hotelDb.create(hotel);
    }

    public Hotel getHotelById(int hotelId){
        return hotelDb.getById(hotelId);
    }

    public List<Hotel> getAllHotel(){
        return hotelDb.getAll();
    }

    public List<Hotel> getHotelByOdrerId(int orderId){
        return hotelDb.getHotelByOrderID(orderId);
    }

    public boolean updateHotel(Hotel hotel){
        return hotelDb.update(hotel);
    }

    public boolean deleteHotel(Hotel hotel){
        return hotelDb.delete(hotel);
    }
}
