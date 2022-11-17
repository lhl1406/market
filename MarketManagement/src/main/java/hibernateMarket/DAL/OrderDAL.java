package hibernateMarket.DAL;

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
        List orderList = session.createQuery("FROM "+Order.class.getName()).list();
        session.getTransaction().commit();
        return orderList;
    }
    
    public Order getOrderById(int orderid){
        Order order = session.get(Order.class, orderid);
        return order;
    }
    
    public void addOrder(Order order){
        session.save(order);
    }
    public static void main(String args[]) {
        OrderDAL dal = new OrderDAL();
//        Order obj = dal.getOrderById(2);
//        System.out.println(obj);
        List<Order> list = dal.getAllOrder();
        
        System.out.println(list.get(0).Note());
////        list.forEach((t) -> {
////            System.out.println(t.toString());
////        });

    }
}
