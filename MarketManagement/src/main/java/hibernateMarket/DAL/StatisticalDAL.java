/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import hibernateMarket.DAL.HibernateUtils;
import java.util.Date;
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

    public List statisticalForTime() {
        String hql = "SELECT v.VegetableID, o.OrderID, v.VegetableName, SUM(d.Quantity), "
                + "SUM(d.Price)*d.Quantity, c.CustomerID, o.Date from vegetable v,"
                + " orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID"
                + " and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID GROUP BY VegetableID";
        System.out.println(hql);
        Query query = session.createQuery(hql);
        List results = query.list();
        return results;
    }

    //SELECT SUM(d.Price)*d.Quantity, MONTH(o.Date) from vegetable v, orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID and MONTH(o.Date) = 8 GROUP BY MONTH(o.Date);
    public List<Object[][]> statisticalForProduct(String startDate, String endDate, String categoryID) {
        String hql = "SELECT o.OrderID, v.VegetableName, SUM(d.Quantity), d.Price"
                + ", SUM(d.Price)*d.Quantity, c.CustomerID, o.Date, v.VegetableID from vegetable v,"
                + " orderdetail d, orders o, customers c where v.VegetableID = d.VegetableID " + categoryID
                + " and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID "
                + " and o.Date >= '" + startDate + "' and o.Date <= '" + endDate
                + "' GROUP BY VegetableID";
//        String hql = "SELECT FullName, Address FROM Customers";
        Query query = session.createNativeQuery(hql);
        List<Object[][]> listResult = query.list();
        return listResult;
    }

    public static void main(String[] args) {
        StatisticalDAL dal = new StatisticalDAL();
//        dal.statisticalForTime();
    }
}
