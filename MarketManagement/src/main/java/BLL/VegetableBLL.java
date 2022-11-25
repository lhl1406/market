package BLL;

//import hibernateMarket.DAL.Category;
import hibernateMarket.DAL.Vegetable;
import hibernateMarket.DAL.VegetableDAL;
import java.sql.SQLException;
import java.util.List;

public class VegetableBLL {

    private VegetableDAL vegDAL;
    private List<Vegetable> list;

    public VegetableBLL() {
        vegDAL = new VegetableDAL();
    }

    public Object[][] converVegetable(List<Vegetable> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetableName();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getAmount();
            obj[i][4] = list.get(i).getImage();
            obj[i][5] = list.get(i).getPrice();
        }
        return obj;
    }

    public Object[][] converImport(List<Vegetable> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetableName();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getPrice();
            obj[i][4] = list.get(i).getAmount();
        }
        return obj;
    }
//  public List getCateID(int cateID) throws SQLException{
//      List<Category> category;
//      category = vegDAL.getVegetableInCategory(cateID);
//      return category;
//  }

    public List loadVegetable() {
        List list;
        list = vegDAL.loadVegetable();
        return list;
    }
//  public int addVegetable(Vegetable v) throws SQLException{
//      int result = vegDAL.addVegetable(v);
//      return result;
//  }
//  public int updateVegetable(Vegetable v) throws SQLException{
//      int result = vegDAL.updateVegetable(v);
//      return result;
//  }
//  public int updateAmount(Vegetable v) throws SQLException{
//      int result = vegDAL.updateAmount(v);
//      return result;
//  }

    public int deleteVegetable(int vegID) throws SQLException {
        int result = vegDAL.deleteVegetable(vegID);
        return result;
    }

    public Vegetable getVegetable(int vegetableID) {

        Vegetable result = vegDAL.getVegetable(vegetableID);
        return result;
    }

    public List searchVegetableName(String vegName) throws SQLException {
        List list;
        list = vegDAL.searchVegetableName(vegName);
        return list;
    }

    public int getLastID() {
        List<Vegetable> vegList = null;
        int ID = 0;
        vegList = vegDAL.loadVegetable();
        for (int i = 0; i < vegList.size(); i++) {
            ID = vegList.get(i).getVegetableID();
        }
        return ID;
    }

    public List loadTableImport(int ID) {
        List list;
        list = vegDAL.loadTableImport(ID);
        return list;
    }

    //================================================
    public List getListVegIDBLL() {
        return vegDAL.getListVegetableID();
    }
    
    public Double getVegPriceBLL(String VegID){
        int vegID = Integer.parseInt(VegID);
        return vegDAL.getVegetablePrice(vegID);
    }
}
