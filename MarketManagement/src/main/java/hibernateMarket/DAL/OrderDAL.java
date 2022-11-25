
package hibernateMarket.DAL;
import BLL.OrderBLL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Tran Ngan
 */
public class OrderDAL {
    public Session session;

    public OrderDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List getAllOrder() {
        session.beginTransaction();
        List orderList = session.createQuery("FROM " + Order.class.getName()).list();
        session.getTransaction().commit();
        return orderList;
    }
    
//    public List getDetail(){
//        session.beginTransaction();
////        String hql = "Select OrderID FROM Orderdetail";
////        List list = session.createQuery(hql).list();
//        List list = session.createQuery("FROM " + Orderdetail.class.getName()).list();
//
//        session.getTransaction().commit();
//        return list;
//    }

    public Order getOrderById(int orderid) {
        Order order = session.get(Order.class, orderid);
        return order;
    }

    public List getListOrderID() {
        session.beginTransaction();
        String hql = "Select OrderID FROM Order";
        List list = session.createQuery(hql).list();
        session.getTransaction().commit();
        return list;
    }

    public void updateOrder(int orderID, int cusID, Date date, float total, String note) {
        session.beginTransaction();
        String hql = "UPDATE Order set CustomerID = :cusid , Date = :date ,Total = :total , Note = :note " + "WHERE OrderID = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("cusid", cusID);
        query.setParameter("date", date);
        query.setParameter("total", total);
        query.setParameter("note", note);
        query.setParameter("Id", orderID);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void addOrder(int orderID, int cusID, String date, float total, String note) {
        session.beginTransaction();
//        System.out.println(date);
//        String hql = "insert into order1 (OrderID , CustomerID , Date , Total , Note)"
//                + "values(' :orderID ', ':cusID' , ':date' , ':total' , ':note')";
        
        String hql2 = "INSERT INTO order1 (OrderID , CustomerID , Date , Total , Note)"
                + " VALUES ('" + orderID + "','" + cusID +"','" + date + "', '" +total +"', '')";
        Query query = session.createNativeQuery(hql2);
//        
////        Query query = session.createNativeQuery(hql);
//        query.setParameter("orderID", orderID);
//        query.setParameter("cusid", cusID);
//        query.setParameter("date", date);
//        query.setParameter("total", total);
//        query.setParameter("note", note);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void deleteOrder(int orderID) {
        session.beginTransaction();
        String hql = "DELETE Order " + "WHERE OrderID = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("Id", orderID);
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
    public List findOrder(int orderID , int cusID ){
        session.beginTransaction();
        String hql = "FROM Order where CustomerID = :cusID and OrderID = :orderID";
        Query query = session.createQuery(hql);
        query.setParameter("cusID", 1);
        query.setParameter("orderID", 0);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }
    
    public List getOrderInCustomer(int customerID) {
         session.beginTransaction();
        String hql = "FROM Order where CustomerID = :cusID";
        Query query = session.createQuery(hql);
        query.setParameter("cusID", customerID);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

}

