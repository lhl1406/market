/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author VIVOBOOK
 */
public class OrderdetailDAL {
     public Session session;

    public OrderdetailDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List getDetail(int id){
        session.beginTransaction();
        String hql = "Select o.OrderID FROM Orderdetail o where o.OrderID = :id";
        Query query = session.createNativeQuery(hql);
        query.setParameter("id", id);
        List list = query.list();
        
//        List list = session.createQuery("FROM " + Orderdetail.class.getName()).list();

        return list;
    }
    
     public void addDetail(){
        session.beginTransaction();
        String hql2 = "INSERT INTO Orderdetail (OrderID , VegetableID , Quantity , Price)"
                + " VALUES ('" + 0 + "','" + 8 +"','" + 2 + "', '" +300000+"' )";
        Query query = session.createNativeQuery(hql2);
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void deteleDetail(int orderId , int vegetableId){
        session.beginTransaction();
        String hql2 = "DELETE Orderdetail " + "WHERE OrderID = :orderid and VegetableID = :vegetableID";
        Query query = session.createQuery(hql2);
        query.setParameter("orderid", orderId);
        query.setParameter("vegetableID", vegetableId);
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void updateDetail(){
        session.beginTransaction();
        String hql = "UPDATE Orderdetail set Quantity=3 " + "WHERE OrderID = 2 and VegetableID = 7";
        Query query = session.createQuery(hql);

        query.executeUpdate();
         session.getTransaction().commit();

    }
    public static void main(String[] args) {
        OrderdetailDAL dal = new OrderdetailDAL();
//        System.out.println(dal.getDetail().size());
    }
}
