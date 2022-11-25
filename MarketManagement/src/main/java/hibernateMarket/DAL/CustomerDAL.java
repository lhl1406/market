package hibernateMarket.DAL;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomerDAL {

    Session session;

    public CustomerDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCustomer() {
        List<Customers> cus = null;

        session.beginTransaction();
        cus = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();

        return cus;
    }
    
    public List searchCustomerID (int CusID) throws SQLException 
    {
        List<Customers> cus = null;
        
        session.beginTransaction();
        Query q = session.createQuery("FROM Customers WHERE CustomerID = :cusID");
        q.setParameter("cusID", CusID);
        cus = q.list();
        session.getTransaction().commit();
        
        return cus;
    }
    
    public List searchCustomerName (String CusName) throws SQLException 
    {
        List<Customers> cus = null;
        
        session.beginTransaction();
        Query q = session.createQuery("FROM Customers WHERE FullName = :Name");
        q.setParameter("Name", CusName);
        cus = q.list();
        session.getTransaction().commit();
        
        return cus;
    }
    
     public List searchCustomerAddress (String CusAddress) throws SQLException 
    {
        List<Customers> cus = null;
        
        session.beginTransaction();
        Query q = session.createQuery("FROM Customers WHERE Address = :Address");
        q.setParameter("Address", CusAddress);
        cus = q.list();
        session.getTransaction().commit();
        
        return cus;
    }
    
    public Customers getCustomer(int CustomerID) {
        Customers c = session.get(Customers.class, CustomerID);
        return c;
    }

    public int addCustomer(Customers c) throws SQLException {

        int result = -1;
        try {
            session.beginTransaction();
            
            Customers cus = new Customers();
            cus.setFullName(c.getFullName());
            cus.setAddress(c.getAddress());
            cus.setCity(c.getCity());

            session.save(cus);
            session.getTransaction().commit();
            
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }

    public int updateCustomer(Customers c)  throws SQLException {
        int result = -1;
        try {
            session.beginTransaction();
            
            Customers cus = new Customers();
            cus.setFullName(c.getFullName());
            cus.setAddress(c.getAddress());
            cus.setCity(c.getCity());

            session.update(c);
            session.getTransaction().commit();
            
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;      
    }

    public int deleteCustomer(int cusID) {
        int result = -1;
        try {
            session.beginTransaction();
            
            Customers cus = session.get(Customers.class, cusID);
            session.delete(cus);
            session.getTransaction().commit();
            
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }
    
    
    //===========================================================
    public List getListCusID(){
        session.beginTransaction();
        String hql = "Select CustomerID FROM Customers";
        List list =session.createQuery(hql).list();
        session.getTransaction().commit();
        return list;
    }
         
}
