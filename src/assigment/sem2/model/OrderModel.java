package assigment.sem2.model;

import assigment.sem2.entity.Order;
import assigment.sem2.view.OrderViewImplement;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderModel {
    boolean save(Order obj);
    List<Order> findAll();
    Order findById(String id);
    boolean update(String id, Order updateOrder);
    boolean delete(String id);
    List<Order> findByTime(String beginDate, String endDate);
    List<Order> findByStatus(String beginDate, String endDate, int paid);

}
