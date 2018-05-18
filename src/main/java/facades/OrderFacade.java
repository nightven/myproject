package facades;

import dao.OrderDAO;
import dao.ToursDAO;
import dao.UserDAO;
import dao.daoImpl.OrderDatabaseDAO;
import model.Order;

import java.util.List;

public class OrderFacade {
//    private UserDAO userDAO;
//    private ToursDAO toursDAO;
//    private OrderDAO orderDAO;

//    public List<OrderDatabaseDAO> getOrdersDao(){
//        List<Order> orders = (List<Order>) orderDAO.getAll();
//        List<OrderDatabaseDAO> resulyList = new ArrayList<>();
//        for (Order order : orders
//                ) {
//            OrderDatabaseDAO oDD = new OrderDatabaseDAO();
//            oDD.set()
//        }
//    }
    OrderDatabaseDAO orderDB = new OrderDatabaseDAO();

    public boolean createOrder(Order order){
        return  orderDB.create(order);
    }

    public  Order getOrderById(int orderId){
        return orderDB.getById(orderId);
    }

    public List<Order> getAllOdrders(){
        return orderDB.getAll();
    }
}
