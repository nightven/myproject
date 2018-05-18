package dao;


import model.Hotel;

import java.util.List;

public interface HotelDAO extends ItemDAO<Hotel>{

   public List<Hotel> getHotelByOrderID(int orderId);


}
