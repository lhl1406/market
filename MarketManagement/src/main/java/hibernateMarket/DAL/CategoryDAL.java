package hibernateMarket.DAL;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoryDAL {

    Session session;

    public CategoryDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadCategory() {
        List<Category> category = null;

        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();

        return category;
    }
    public List searchCategoryID (int CateID) throws SQLException 
    {
        List<Category> category = null;
        session.beginTransaction();
        Query q = session.createQuery("FROM Category WHERE CatagoryID = :categoryID");
        q.setParameter("categoryID", CateID);
        category = q.list();
        session.getTransaction().commit();
        return category;
    }
    public List searchCategoryName (String cateName) throws SQLException 
    {
        List<Category> category = null;
        session.beginTransaction();
        Query q = session.createQuery("FROM Category WHERE Name = :Name");
        q.setParameter("Name", cateName);
        category = q.list();
        session.getTransaction().commit();
        return category;
    }
    

    public Category getCategory(int CategoryID) {
        Category c = session.get(Category.class, CategoryID);
        return c;
    }

    public int addCategory(Category c) throws SQLException {

        int result = -1;
        try {
            session.beginTransaction();
            Category cate = new Category();
            cate.setCatagoryID(c.getCatagoryID());
            cate.setName(c.getName());
            cate.setDescription(c.getDescription());

            session.save(cate);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }

    public int updateCategory(Category c)  throws SQLException {
        int result = -1;
        try {
            session.beginTransaction();
            Category cate = new Category();
            cate.setCatagoryID(c.getCatagoryID());
            cate.setName(c.getName());
            cate.setDescription(c.getDescription());

            session.update(c);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;      
    }

    public int deleteCategory(int cateID) {
        int result = -1;
        try {
            session.beginTransaction();
            Category c = session.get(Category.class, cateID);
            session.delete(c);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception ex) {
            System.out.println(ex);
            result = -1;
        }
        return result;
    }
    
           
}
