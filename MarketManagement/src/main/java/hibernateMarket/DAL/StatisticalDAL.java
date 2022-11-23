/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import hibernateMarket.DAL.HibernateUtils;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StatisticalDAL {

    Session session;

    public StatisticalDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
// 
//    Date startDate, Date endDate, int categoryID
//    SELECT v.VegetableID, o.OrderID, v.VegetableName, SUM(d.Quantity), SUM(d.Price)*d.Quantity, c.CustomerID, o.Date, ca.CatagoryID from vegetable v, orderdetail d, orders o, customers c, category ca where v.VegetableID = d.VegetableID and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID and o.Date >= '2021/08/15' and o.Date <= '2021/08/16' and v.CatagoryID = ca.CatagoryID and ca.CatagoryID = 1 GROUP BY VegetableID, o.OrderID ORDER BY o.Date DESC;
//    Date startDate, Date endDate, int productID
//    SELECT v.VegetableID, o.OrderID, v.VegetableName, SUM(d.Quantity), SUM(d.Price)*d.Quantity, c.CustomerID, o.Date from vegetable v, orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID and o.Date >= '2021/08/15' and o.Date <= '2021/08/16' and v.VegetableID = 1 GROUP BY VegetableID, o.OrderID ORDER BY o.Date DESC;

//    public List statisticalForProduct() {
//        String hql = "SELECT v.VegetableID, o.OrderID, v.VegetableName, SUM(d.Quantity), "
//                + "SUM(d.Price)*d.Quantity, c.CustomerID, o.Date from vegetable v,"
//                + " orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID"
//                + " and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID GROUP BY VegetableID";
//        Query query = session.createQuery(hql);
//        List results = query.list();
//        return results;
//    }
    //SELECT SUM(d.Price)*d.Quantity, MONTH(o.Date) from vegetable v, orderdetail d, orders o, customers c where
    //v.VegetableID = d.VegetableID and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID and MONTH(o.Date) = 8 GROUP BY MONTH(o.Date);
    public List statisticalForTime() {
        String hql = "SELECT v.VegetableID, o.OrderID, v.VegetableName, SUM(d.Quantity), "
                + "SUM(d.Price)*d.Quantity, c.CustomerID, o.Date from vegetable v,"
                + " orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID"
                + " and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID  and o.Date =  '2021-08-15' GROUP BY VegetableID ";
//        String hql = "SELECT FullName, Address FROM Customers";
        System.out.println(hql);
        Query query = session.createNativeQuery(hql);
        List<Object[][]> listResult = query.list();
        int lenght = listResult.size();
        int i = 0;
        Object data[][] = new Object[lenght][7];
        for (Object aRow[] : listResult) {
            data[i][0] = aRow[0];
            data[i][1] = aRow[1];
            data[i][2] = aRow[2];
            data[i][3] = aRow[3];
            data[i][4] = aRow[4];
            data[i][5] = aRow[5];
            data[i][6] = aRow[6];
//            data[i][7] = aRow[7];
            if (i < lenght) {
                i = i + 1;
            } else {
                break;
            }
        }
        
        for(int j = 0; j < lenght; j++) {
            for(int k = 0; k < 7; k++) {
                System.out.print(data[j][k]+" - ");
            } 
            System.out.println("");
        }
        return listResult;
    }

    public static void main(String[] args) {
        StatisticalDAL dal = new StatisticalDAL();
        dal.statisticalForTime();
    }
}
