package assigment.sem2.model;

import assigment.sem2.Util.DateTimeUtil;
import assigment.sem2.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModelImplement implements OrderModel {

    private List<Order> list;

    {
        list = new ArrayList<Order>();
        list.add(new Order("Order001", "Xuan Kien", "1 con ga, 2 con ngan", 200, "2020-09-10", 1));
        list.add(new Order("Order002", "Xuan Cuong", "1 con ga, 2 con ngan", 30000, "2008-09-10", 2));
        list.add(new Order("Order003", "Xuan Hung", "1 con ga, 2 con ngan", 20000, "2015-09-10", 1));
        list.add(new Order("Order004", "Xuan Chung", "1 con ga, 2 con ngan", 2000, "2019-09-10", 2));
        list.add(new Order("Order004", "Xuan Chung", "1 con ga, 2 con ngan", 2000, "2011-09-10", 1));
        list.add(new Order("Order004", "Xuan Chung", "1 con ga, 2 con ngan", 2000, "2021-09-10", 0));

    }

//    public OrderModelImplement(){
//    this.list = new ArrayList<>();
//    }

    @Override
    public boolean save(Order obj) {
        list.add(obj);
        return true;
    }

    @Override
    public List<Order> findAll() {
        return list;
    }

    @Override
    public Order findById(String id) {
        Order order = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                order = list.get(i);
                break;
            }
        }
        return order;
    }

    public List<Order> findByTime(String beginDate, String endDate) {
        List<Order> listSearchResult = new ArrayList<>();
        Order order = null;
        Date bDate = DateTimeUtil.parseDateFromString(beginDate);
        Date eDate = DateTimeUtil.parseDateFromString(endDate);
        for (int i = 0; i < list.size(); i++) {
            Date curr = list.get(i).getDob();
            if (curr.compareTo(bDate) > 0 && curr.compareTo(eDate) < 0){
                order = list.get(i);
                listSearchResult.add(order);
            }
        }
        return listSearchResult;
    }

    public List<Order> findByStatus(String bDate, String eDate, int status){
        List<Order> existingSearchResult = findByTime(bDate, eDate);
        List<Order> searchByStatus = new ArrayList<>();
        for (int i = 0; i < existingSearchResult.size(); i++) {
            if (status == existingSearchResult.get(i).getStatus()){
                searchByStatus.add(existingSearchResult.get(i));
            }
        }
        return searchByStatus;
    }

    @Override
    public boolean update(String id, Order updateOrder) {
        Order existingOrder = findById(id);
        if (existingOrder == null) {
            return false;
        }
        existingOrder.setCustomer(updateOrder.getCustomer());
        existingOrder.setProductName(updateOrder.getProductName());
        existingOrder.setStatus(updateOrder.getStatus());
        return true;
    }

    @Override
    public boolean delete(String id) {
        Order existingOrder = findById(id);
        if (existingOrder == null) {
            return false;
        }
        list.remove(existingOrder);
        return true;
    }
}
