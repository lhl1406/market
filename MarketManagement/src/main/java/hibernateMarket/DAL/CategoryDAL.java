package hibernateMarket.DAL;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void updateCategory(Category c) {
        session.update(c);
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
