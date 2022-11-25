/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernateMarket.DAL.OrderDAL;
import hibernateMarket.DAL.Order;
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

    public int addOrderBLL( String CusID, String note) throws ParseException {

        int cusID = Integer.parseInt(CusID);
        Date d = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(d);
        int check = orderDAL.addOrder( cusID, date, note);
        return check;
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

    public void updateTotalBLL(String Total) {
        float total = Float.parseFloat(Total);
        orderDAL.updateTotal(total);
    }

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }

    public static void main(String[] args) {
//        OrderBLL bll = new OrderBLL();

//        System.out.println(bll.getOrderBLL(1).getCustomer().getCustomerID());
    }
}
