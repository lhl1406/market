/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import java.util.ArrayList;
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

    public List<Orderdetail> getDetail(int id) {
        session.beginTransaction();
//        String hql = "FROM Orderdetail";
//        Query query = session.createQuery(hql);

//                List list = session.createQuery("FROM " + Orderdetail.class.getName()).list();
//                        session.getTransaction().commit();
//        query.setParameter("id", id);
//        List list =query.list();
        Query query = session.createQuery("FROM " + Orderdetail.class.getName() + " where OrderID = :id");
        query.setParameter("id", id);
        List list = query.list();
        return list;
    }

    public int addDetail(int OrderID, int VegId, int quantity, float price) {
        session.beginTransaction();
        String hql2 = "INSERT INTO Orderdetail (OrderID , VegetableID , Quantity , Price)"
                + " VALUES ('" + OrderID + "','" + VegId + "','" + quantity + "', '" + price + "' )";
        Query query = session.createNativeQuery(hql2);
        query.executeUpdate();
        session.getTransaction().commit();
        return 1;
    }

    public int deteleDetail(int orderId, int vegetableId) {
        session.beginTransaction();
        String hql2 = "DELETE Orderdetail " + "WHERE OrderID = :orderid and VegetableID = :vegetableID";
        Query query = session.createQuery(hql2);
        query.setParameter("orderid", orderId);
        query.setParameter("vegetableID", vegetableId);
        query.executeUpdate();
        session.getTransaction().commit();
        return 1;
    }

    public int updateDetail(int OrderID, int VegId, int quantity, float price, int vegCur) {
        session.beginTransaction();
        String hql = "UPDATE Orderdetail set VegetableID = :vegId ,Quantity= :quantity , Price= :price "
                + "WHERE OrderID = :orderID and VegetableID = :vegIdCur";
        Query query = session.createQuery(hql);
        query.setParameter("orderID", OrderID);
        query.setParameter("vegId", VegId);
        query.setParameter("quantity", quantity);
        query.setParameter("price", price);
        query.setParameter("vegIdCur", vegCur);

        query.executeUpdate();
        session.getTransaction().commit();
        return 1;
    }

    public Double getTotalOrder(int OrderID) {
        session.beginTransaction();
        String hql = "Select SUM(Price) FROM orderdetail where OrderID = :id";
        Query query = session.createNativeQuery(hql);
        query.setParameter("id", OrderID);
        Double result = (Double) query.uniqueResult();
        session.getTransaction().commit();
        return result;
    }

    public int checkOrdetail(int OrderID) {
        session.beginTransaction();
        Query query = session.createQuery("FROM " + Orderdetail.class.getName() + " where OrderID = :id");
        query.setParameter("id", OrderID);
        List list = query.list();
        return list.size();
    }

    public static void main(String[] args) {
        OrderdetailDAL dal = new OrderdetailDAL();
//        System.out.println(dal.getTotalOrder(1));
//        System.out.println(dal.getDetail(0).get(0));
//        List<Orderdetail> d = dal.getDetail(0);
//        System.out.println(d.get(0));
    }
}
