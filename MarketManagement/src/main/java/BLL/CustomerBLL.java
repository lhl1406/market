package BLL;

import hibernateMarket.DAL.CustomerDAL;
import hibernateMarket.DAL.Customers;
import java.sql.SQLException;
import java.util.List;

public class CustomerBLL {
    private CustomerDAL cusDAL;
    
    private OrderBLL ordBLL;
    
    public CustomerBLL()
    {
        cusDAL = new CustomerDAL();
    }
    
    public List loadCustomer()
    {
        List list;
        list = cusDAL.loadCustomer();
        
        return list;
    }
    
    public Customers getCustomer(int CustomerID)
    {
        Customers c = cusDAL.getCustomer(CustomerID);
        return c;
    }
    
    public List searchCustomerID (int cusID) throws SQLException 
    {
        List list;
        list = cusDAL.searchCustomerID(cusID);
        return list;
    }
    
    public List searchCustomerName (String cusName) throws SQLException 
    {
        List list;
        list = cusDAL.searchCustomerName(cusName);
        
        return list;
    }
    
    public List searchCustomerAddress (String cusAddress) throws SQLException 
    {
        List list;
        list = cusDAL.searchCustomerAddress(cusAddress);
        
        return list;
    }
    
    public Customers[] convertList1 (List<Customers> list)
    {
        int rows = list.size();
        Customers[] newList = new Customers[rows];
        for(int i = 0; i < rows; i++)
        {
            newList[i] = list.get(i);
            
        }
        return newList;
    }
    public Object[][] convertList(List<Customers> list)
    {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getFullName();
            obj[i][2] = list.get(i).getPassword();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
            //obj[i][4] = list.get(i).getListOrder().size();
        }
        return obj;
    }
    
    public int addCustomer(Customers c) throws SQLException
    {
       int result = cusDAL.addCustomer(c);
       return result;
    }
    
    public int updateCustomer(Customers c) throws SQLException
    {
       int result = cusDAL.updateCustomer(c);
       return result;
    }
    
    public int deleteCustomer(int cusID) throws SQLException{
//       int result = cusDAL.deleteCustomer(cusID);
//       return result;
       ordBLL = new OrderBLL();
       if (ordBLL.getCusID(cusID).isEmpty() == false) {
            return 0;
        }
       int result = cusDAL.deleteCustomer(cusID);
       return result;
    }
    
    public int getLastID(){
        List<Customers> cus=null;
        int ID=0;
        cus=cusDAL.loadCustomer();
        for(int i=0; i<cus.size();i++){
            ID = cus.get(i).getCustomerID();
        }
        return ID;
    }
    
//    public void update(String cusID, String fullname, String pass, String add, String city) throws ParseException {
//        int ID = Integer.parseInt(cusID);
////        String fullname2 = fullname;
////        String pass2 = pass;
////        String add2 = add;
////        String city2 = city;
//        cusDAL.update(ID, fullname, pass, add, city);
//    }

//    public int deleteCustomer(int cusID) throws SQLException{
//        
//       ordBLL = new OrderBLL();
//       if (ordBLL.getCusID(cusID).isEmpty() == false) {
//            return 0;
//        }
//       int result = cusDAL.deleteCustomer(cusID);
//       return result;
//    }
    
   
    
    
    //========================================================
    public List getListCusIDBLL(){
        return cusDAL.getListCusID();
    }
    
}
