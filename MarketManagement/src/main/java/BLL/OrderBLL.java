package BLL;

import hibernateMarket.DAL.Customers;
import hibernateMarket.DAL.OrderDAL;
import hibernateMarket.DAL.Order;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author Tran Ngan
 */
public class OrderBLL {
    public static List<Order> DSHD;
    private OrderDAL orderDAL;

    public List<Order> getAllOrderBLL() {
        if (DSHD == null) {
            DSHD = orderDAL.getAllOrder();
        }
        return DSHD;
    }

    public Order getOrderBLL(int id) {
        Order order = orderDAL.getOrderById(id);
        return order;
    }

    public List getListOrderIdBLL() {
        return orderDAL.getListOrderID();
    }

    public void editOrderBLL(String orderID, String CusID, String date, String Total, String note) throws ParseException {
        int ordID = Integer.parseInt(orderID);
        int cusID = Integer.parseInt(CusID);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        float total = Float.parseFloat(Total);
        orderDAL.updateOrder(ordID, cusID, date2, total, note);
    }

    public void deleteOrderBLL(String orderID) {
        int ordID = Integer.parseInt(orderID);
        orderDAL.deleteOrder(ordID);
    }

    public void addOrderBLL(String orderID, String CusID, String date, String Total, String note) throws ParseException {
        int ordID = Integer.parseInt(orderID);
        int cusID = Integer.parseInt(CusID);
        Date tamp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(tamp);
        float total = Float.parseFloat(Total);
        orderDAL.addOrder(ordID, cusID, date2, total, note);
    }

    public List findOrderBLL(String orderID, String cusID) {
        int orderid = Integer.parseInt(orderID);
        int cusid = Integer.parseInt(cusID);
        List list = orderDAL.findOrder(orderid, cusid);
        return list;
    }

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }
    
    public List getCusID(int cusID) throws SQLException{
      List<Customers> customer;
      customer = orderDAL.getOrderInCustomer(cusID);
      return customer;
    }
    

}