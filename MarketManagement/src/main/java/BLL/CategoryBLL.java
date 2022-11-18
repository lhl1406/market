package BLL;

import hibernateMarket.DAL.Category;
import hibernateMarket.DAL.CategoryDAL;
import java.sql.SQLException;
import java.util.List;

public class CategoryBLL {
    private CategoryDAL cateDAL;
    private VegetableBLL vegBLL;
    
    
    public CategoryBLL()
    {
        cateDAL = new CategoryDAL();
    }
    
    public List loadCategory()
    {
        List list;
        list = cateDAL.loadCategory();
        
        return list;
    }
    public Category[] convertList1 (List<Category> list)
    {
        int rows = list.size();
        Category[] newList = new Category[rows];
        for(int i = 0; i < rows; i++)
        {
            newList[i] = list.get(i);
            
        }
        return newList;
    }
    public Object[][] convertList(List<Category> list)
    {
        int rows = list.size();
        int cols = 3;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            //obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }
    public int newCategory(Category c) throws SQLException
    {
       int result = cateDAL.addCategory(c);
       return result;
    }
    public int deleteCategory(int cateID) throws SQLException{
        
       vegBLL = new VegetableBLL();
       if (vegBLL.getCateID(cateID).isEmpty() == false) {
            return 0;
        }
       int result = cateDAL.deleteCategory(cateID);
       return result;
    }
    public Category getCategory(int CategoryID)
    {
        Category c = cateDAL.getCategory(CategoryID);
        return c;
    }
}
