/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import hibernateMarket.DAL.OrderdetailDAL;
import java.util.List;

/**
 *
 * @author VIVOBOOK
 */
public class OrderDetailBLL {
    private OrderdetailDAL orderdetailDAL;
    
    public OrderDetailBLL(){
        orderdetailDAL = new OrderdetailDAL();
    }
    public List getOrderByIDBLL(String id){
        int orderId = Integer.parseInt(id);
        return orderdetailDAL.getDetail(orderId);
    }
    
    public void deteleOrderdetailBLL(String OrderId , String vegetableID){
        int orderid = Integer.parseInt(OrderId);
        int vegetableId = Integer.parseInt(vegetableID);
        orderdetailDAL.deteleDetail(orderid, vegetableId);
    }
    
    public void updateOrderDetailBLL(String vegetableID , String quantity ){
        
    }
}
