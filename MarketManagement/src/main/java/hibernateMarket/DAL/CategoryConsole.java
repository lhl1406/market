package hibernateMarket.DAL;

import BLL.CategoryBLL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class CategoryConsole {

    private CategoryBLL cateBLL;

    public CategoryConsole() {
        cateBLL = new CategoryBLL();
    }

    public void showListCategory(){
        List cates = cateBLL.loadCategory();
        for (Iterator iterator = cates.iterator(); iterator.hasNext();) {
            Category cate = (Category) iterator.next();
            System.out.print("ID: " + cate.getCatagoryID());
            System.out.print("Name: " + cate.getName());
            System.out.println("Description: " + cate.getDescription());
            System.out.println("Num of Vegetable: " + cate.getListVegetable().size());
        }

    }

    public void getVegetableInCategory(int CategoryID) {
        Category cate = cateBLL.getCategory(CategoryID);
        System.out.println("Num of Vegetable: " + cate.getListVegetable().size());
    }

    public void addNewCategory(int id, String name, String des) throws SQLException {
        Category c = new Category();
        c.setCatagoryID(id);
        c.setName(name);
        c.setDescription(des);

        cateBLL.newCategory(c);
    }

    public static void main(String[] args) throws SQLException {

//        CategoryConsole c = new CategoryConsole();
//        int id = 4;
//        String name = "beep";
//        String des = " beep beep";
//        //c.addNewCategory(id,name, des);
//        c.showListCategory();
        //c.getVegetableInCategory(1);
    }
}
