package hibernateMarket.DAL;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class VegetableDAL {

    Session session;

    public VegetableDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public Vegetable getVegetable(int vegetableID) {
        
        Vegetable v = session.get(Vegetable.class, vegetableID);
        return v;
    }

    public List getVegetableInCategory(int categoryID) {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE CatagoryID = :categoryID");
        q.setParameter("categoryID", categoryID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }

    public List loadVegetable(){
        List<Vegetable> list;
        session.beginTransaction();
        list = session.createQuery("FROM Vegetable", Vegetable.class).list();
        session.getTransaction().commit();
        return list;
    }

//    public int addVegetable(Vegetable v) throws SQLException {
//        int result = -1;
//        try {
//            session.beginTransaction();
//            Vegetable veg = new Vegetable();
//            veg.setVegetableID(v.getVegetableID());
//            veg.setCatagory(v.getCatagory());
//            veg.setVegetableName(v.getVegetableName());
//            veg.setUnit(v.getUnit());
//            veg.setAmount(v.getAmount());
//            veg.setImage(v.getImage());
//            veg.setPrice(v.getPrice());
//
//            session.save(veg);
//            session.getTransaction().commit();
//            result = 1;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            result = -1;
//        }
//        return result;
//    }

//    public int updateVegetable(Vegetable v) throws SQLException {
//        int result = -1;
//        try {
//            session.beginTransaction();
//            Vegetable veg = new Vegetable();
//            veg.setVegetableID(v.getVegetableID());
//            veg.setCatagory(v.getCatagory());
//            veg.setVegetableName(v.getVegetableName());
//            veg.setUnit(v.getUnit());
//            veg.setAmount(v.getAmount());
//            veg.setImage(v.getImage());
//            veg.setPrice(v.getPrice());
//
//            session.update(v);
//            session.getTransaction().commit();
//            result = 1;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            result = -1;
//        }
//        return result;
//    }
    public int updateAmount(Vegetable v) throws SQLException {
        int result = -1;
        try {
            session.beginTransaction();
            Vegetable veg = new Vegetable();    
            veg.setAmount(v.getAmount());
            session.update(v);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }

    public int deleteVegetable(int vegID) throws SQLException  {
        int result = -1;
        try {
            session.beginTransaction();
            Vegetable v = session.get(Vegetable.class, vegID);
            session.delete(v);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }
    public List searchVegetableName (String vegName) throws SQLException 
    {
        List<Vegetable> Vegetable = null;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE VegetableName = :VegetableName");
        q.setParameter("VegetableName", vegName);
        Vegetable = q.list();
        session.getTransaction().commit();
        return Vegetable;
    }
    public List loadTableImport(int ID){
        
        List<Vegetable> list = null;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE CatagoryID = :CatagoryID");
        q.setParameter("CatagoryID", ID);
        list= q.list();
        session.getTransaction().commit();
        return list;
    }
    
    public static void main(String[] args) throws SQLException {
        VegetableDAL vegDAL = new VegetableDAL();
        System.out.println(vegDAL.getVegetablePrice(1));
    }
    
    //======================================================
    public List getListVegetableID(){
        session.beginTransaction();
        String hql = "Select VegetableID FROM Vegetable";
        List list =session.createQuery(hql).list();
        session.getTransaction().commit();
        return list;
    }
    public Double getVegetablePrice(int VegID){
       session.beginTransaction();
       String hql = "Select Price FROM Vegetable where VegetableID = :id";
       Query query =session.createQuery(hql);
       query.setParameter("id", VegID);
       Double result =  (Double) query.uniqueResult();   
       session.getTransaction().commit();
       return result; 
    }

}
