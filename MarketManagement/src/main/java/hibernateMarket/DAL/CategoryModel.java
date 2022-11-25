package hibernateMarket.DAL;

import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Session;

public class CategoryModel extends DefaultComboBoxModel<Category> {
    
    Session session;
    
    public CategoryModel(Category[] listCate)
    {
        super(listCate);
    }
//    public int addCategory(Category c) throws SQLException{
//        int result = -1;
//        try {
//            session.beginTransaction();
//            Category cate = new Category();
//            cate.setCatagoryID(c.getCatagoryID());
//            cate.setName(c.getName());
//            cate.setDescription(c.getDescription());
//
//            session.save(cate);
//            session.getTransaction().commit();
//            result = 1;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            result = -1;
//        } finally {
//            session.close();
//        }
//        return result;
//    }
//    public int deleteCategory(int cateID) {
//        int result = -1;
//        try {
//            session.beginTransaction();
//            Category c = session.get(Category.class, cateID);
//            session.delete(c);
//            session.getTransaction().commit();
//            result = 1;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            result = -1;
//        } finally {
//            session.close();
//        }
//        return result;
//    }
}
