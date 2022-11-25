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

import java.util.List;
import java.util.Locale;

/**
 *
 * @author VIVOBOOK
 */
public class OrderBLL {

    private OrderDAL orderDAL;
    
    public List getAllOrderBLL(){
        List OrderList = orderDAL.getAllOrder();
        return OrderList;
    }
    
    public Order getOrderBLL(int id){
        Order order = orderDAL.getOrderById(id);
        return order;
    }
    
    public void addOrderBLL(String CusID , String date , String Total , String note ) throws ParseException{
//        int cusID = Integer.parseInt(CusID);
//        Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(date); 
//        float total = Float.parseFloat(Total);
//        Order newOrder = new Order(cusID,date2,total,note);
//        orderDAL.addOrder(newOrder);
    }

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }
    
    public static void main(String[] args) {
        OrderBLL bll = new OrderBLL();
//        System.out.println(bll.getOrder(1));
    }
}
