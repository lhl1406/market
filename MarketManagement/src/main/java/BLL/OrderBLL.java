
package BLL;

import hibernateMarket.DAL.Customers;
import hibernateMarket.DAL.OrderDAL;
import hibernateMarket.DAL.Order;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

/**
 *
 * @author VIVOBOOK
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

//<<<<<<< HEAD
//    public void editOrderBLL(String orderID, String CusID, String date, String Total, String note) throws ParseException {
//        int ordID = Integer.parseInt(orderID);
//        int cusID = Integer.parseInt(CusID);
//        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//        float total = Float.parseFloat(Total);
//        orderDAL.updateOrder(ordID, cusID, date2, total, note);
//    }
//
//    public void deleteOrderBLL(String orderID) {
//        int ordID = Integer.parseInt(orderID);
//        orderDAL.deleteOrder(ordID);
//    }
//
//    public void addOrderBLL(String orderID, String CusID, String date, String Total, String note) throws ParseException {
//        int ordID = Integer.parseInt(orderID);
//        int cusID = Integer.parseInt(CusID);
//        Date tamp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(tamp);
//        float total = Float.parseFloat(Total);
//        orderDAL.addOrder(ordID, cusID, date2, total, note);
//    }
//
//    public List findOrderBLL(String orderID, String cusID) {
//        int orderid = Integer.parseInt(orderID);
//        int cusid = Integer.parseInt(cusID);
//        List list = orderDAL.findOrder(orderid, cusid);
//        return list;
//    }
//
//    public OrderBLL() {
//        orderDAL = new OrderDAL();
//    }
//    
    public List getCusID(int cusID) throws SQLException{
      List<Customers> customer;
      customer = orderDAL.getOrderInCustomer(cusID);
      return customer;
    }
//    
//
//}
//=======
    public int editOrderBLL(String orderID, String CusID, String date, String note) throws ParseException {
        int ordID = Integer.parseInt(orderID);
        int cusID = Integer.parseInt(CusID);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        int check = orderDAL.updateOrder(ordID, cusID, date2, note);
        return check;
    }

    public int deleteOrderBLL(String orderID) {
        int ordID = Integer.parseInt(orderID);
        int check = orderDAL.deleteOrder(ordID);
        return check;
    }

    public List addOrderBLL( String CusID, String note) throws ParseException {       
        List list = new ArrayList();
        int cusID = Integer.parseInt(CusID);
        Date d = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(d);
        int check = orderDAL.addOrder( cusID, date, note);
        list.add(date);
        list.add(check);
        return list;
    }

    public List findOrderBLL(String orderID, String cusID) {
        int orderid = Integer.parseInt(orderID);    
        List list;
        if(cusID.equals("")){
            list = orderDAL.findOrder2(orderid);
        }
        else{
            int cusid = Integer.parseInt(cusID);
            list = orderDAL.findOrder1(orderid, cusid);
        }
        
        return list;
    }

    public void updateTotalBLL(String Total , String OrderID) {
        float total = Float.parseFloat(Total);
        int ordID = Integer.parseInt(OrderID);

        orderDAL.updateTotal(total,ordID);
    }
    
    public int getLastIDBLL(){
        return orderDAL.getOrderLastID();
    }

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }

    public static void main(String[] args) {
//        OrderBLL bll = new OrderBLL();

//        System.out.println(bll.getOrderBLL(1).getCustomer().getCustomerID());
    }
}
