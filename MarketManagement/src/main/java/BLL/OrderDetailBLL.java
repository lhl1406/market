/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernateMarket.DAL.Orderdetail;
import hibernateMarket.DAL.OrderdetailDAL;
import java.util.List;

/**
 *
 * @author VIVOBOOK
 */
public class OrderDetailBLL {

    private OrderdetailDAL orderdetailDAL;

    public OrderDetailBLL() {
        orderdetailDAL = new OrderdetailDAL();
    }

    public List<Orderdetail> getOrderDetailByIDBLL(String id) {
        int orderId = Integer.parseInt(id);
        return orderdetailDAL.getDetail(orderId);
    }

    public int deteleOrderdetailBLL(String OrderId, String vegetableID) {
        int orderid = Integer.parseInt(OrderId);
        int vegetableId = Integer.parseInt(vegetableID);
        int check = orderdetailDAL.deteleDetail(orderid, vegetableId);
        return check;
    }

    public int addOrderdetailBLL(String OrderID, String VegID, String Quantity, String Price) {
        int orderID = Integer.parseInt(OrderID);
        int quantity = Integer.parseInt(Quantity);
        float price = Float.parseFloat(Price);
        int vegID = Integer.parseInt(VegID);
        int check = orderdetailDAL.addDetail(orderID, vegID, quantity, price);
        return check;
    }

    public int updateOrderDetailBLL(String OrderID, String VegID, String Quantity, String Price, String VegCur) {
        int orderID = Integer.parseInt(OrderID);
        int quantity = Integer.parseInt(Quantity);
        float price = Float.parseFloat(Price);
        int vegID = Integer.parseInt(VegID);
        int vegcur = Integer.parseInt(VegCur);
        int check = orderdetailDAL.updateDetail(orderID, vegID, quantity, price, vegcur);
        return check;
    }

    public String getTotalOrder(String OrderID) {
        int orderID = Integer.parseInt(OrderID);
        Double total = orderdetailDAL.getTotalOrder(orderID);
        return total.toString();
    }
}
