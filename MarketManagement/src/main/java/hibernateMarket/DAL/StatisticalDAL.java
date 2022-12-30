/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import hibernateMarket.DAL.HibernateUtils;
import java.util.Date;
import java.util.List;
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

    public List<Object[][]> statisticalForTime(String dateQuery) {
        String hql = "SELECT SUM(o.Total), o.Date from order1 o where " 
                        + dateQuery + " Group By o.Date";
        System.out.println(hql);
        Query query = session.createNativeQuery(hql);
        List results = query.list();
        return results;
    }

    public List<Object[][]> statisticalForProduct(String startDate, String endDate, String categoryID) {
        String hql = "SELECT o.OrderID, v.VegetableName, SUM(d.Quantity), v.Price"
                + ", v.Price * SUM(d.Quantity) , c.CustomerID, o.Date, v.VegetableID from vegetable v,"
                + " orderdetail d, order1 o, customers c where v.VegetableID = d.VegetableID " + categoryID
                + " and o.OrderID = d.OrderID and c.CustomerID = o.CustomerID "
                + " and o.Date >= '" + startDate + "' and o.Date <= '" + endDate
                + "' GROUP BY VegetableID";
        Query query = session.createNativeQuery(hql);
        List<Object[][]> listResult = query.list();
        return listResult;
    }

    public static void main(String[] args) {
        StatisticalDAL dal = new StatisticalDAL();
//        dal.statisticalForTime();
    }
}
