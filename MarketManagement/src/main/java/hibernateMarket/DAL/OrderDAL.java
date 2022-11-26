package hibernateMarket.DAL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author VIVOBOOK
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

    public int updateOrder(int orderID, int cusID, Date date, String note) {
        session.beginTransaction();
        String hql = "UPDATE Order set CustomerID = :cusid , Date = :date  , Note = :note " + "WHERE OrderID = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("cusid", cusID);
        query.setParameter("date", date);
        query.setParameter("note", note);
        query.setParameter("Id", orderID);
        query.executeUpdate();
        session.getTransaction().commit();
        return 1;
    }

    public int addOrder(int cusID, String date, String note) {
        System.out.println(date);
        session.beginTransaction();
        String hql2 = "INSERT INTO order1 ( CustomerID , Date , Total , Note)"
                + " VALUES ('" + cusID + "','" + date + "', '" + 0 + "', '" + note + "')";
        Query query = session.createNativeQuery(hql2);
        query.executeUpdate();
        session.getTransaction().commit();
        return 1;
    }
    
    public int getOrderLastID(){
        session.beginTransaction();
        String hql = "Select Max(OrderID) FROM Order";
        Query query = session.createQuery(hql);
        int result = (int) query.uniqueResult();
        session.getTransaction().commit();
        return result;
    }
    
    public int deleteOrder(int orderID) {
        int result;
        try {
            session.beginTransaction();
            String hql = "DELETE Order " + "WHERE OrderID = :Id";
            Query query = session.createQuery(hql);
            query.setParameter("Id", orderID);
            query.executeUpdate();
            session.getTransaction().commit();
            result = 1;
        } catch (Exception e) {
            result = 0;
        }

        return result;
    }

    public List findOrder1(int orderID, int cusID) {
        session.beginTransaction();
        String hql = "FROM Order where CustomerID = :cusID and OrderID = :orderID";
        Query query = session.createQuery(hql);
        query.setParameter("cusID", cusID);
        query.setParameter("orderID", orderID);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public List findOrder2(int orderID) {
        session.beginTransaction();
        String hql = "FROM Order where OrderID = :orderID";
        Query query = session.createQuery(hql);
        query.setParameter("orderID", orderID);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public void updateTotal(float total, int OrderID) {
        session.beginTransaction();
        String hql = "UPDATE Order set Total = :total " + "WHERE OrderID = :Id";
        Query query = session.createQuery(hql);
        query.setParameter("total", total);
        query.setParameter("Id", OrderID);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public static void main(String args[]) throws ParseException {
        OrderDAL dal = new OrderDAL();
//        System.out.println(dal.getOrderLastID());

//        dal.addDetail();
//        List order = dal.getDetail();
//        System.out.println(order.size());
//        
//        List order = dal.findOrder(0, 1);
//        System.out.println(order.get(0));

        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-12");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(d2);
//        LocalDate d = LocalDate.now();
        System.out.println(date);
        dal.addOrder(1, date, "sadasdasdasd");
//        List list = dal.getListOrderID();
//        System.out.println(list.get(0));
//        dal.deleteOrder(4);
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-19");
//        System.out.println("Date "+date);
//        dal.updateOrder(1,date,50000);
//        Order obj = dal.getOrderById(2);
//        System.out.println(obj);
//        List<Order> list = dal.getAllOrder();
//        System.out.println(list.get(0));
////        list.forEach((t) -> {
////            System.out.println(t.toString());
////        });
    }
}
