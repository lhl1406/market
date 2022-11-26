/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import UI.Statistical.ForProductForm;
import hibernateMarket.DAL.StatisticalDAL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class StatisticalBLL {
    StatisticalDAL sdal;
    public StatisticalBLL() {
        sdal = new StatisticalDAL();
    }
    public List<Object[][]> statisticalForTime(String startDate, String endDate, int Quater) {
         List<Object[][]> listResult = null;
         String prepareQuery = "";
        if(Quater == -1) {
           prepareQuery = " o.Date >= '" + startDate + "' and o.Date <= '" + endDate +"'";
           listResult = sdal.statisticalForTime(prepareQuery);
        } else {
           prepareQuery = " o.Date >= '" + startDate + "' and o.Date <= '" + 
                        endDate + "' and MONTH(" + Quater +") <= "+ Quater*4 +
                        "and MONTH(" + Quater +") >= " + (Quater - 1)*4 ;
           listResult = sdal.statisticalForTime(prepareQuery);
        }
        return listResult;
    }
    public List<Object[][]> statisticalForProduct(String startDate, String endDate, int categoryID) {
        List<Object[][]> listResult = null;
        if(categoryID == -1) {
           listResult = sdal.statisticalForProduct(startDate, endDate, "");
        } else {
           listResult = sdal.statisticalForProduct(startDate, endDate, "and v.CatagoryID = " + categoryID);
        }
        return listResult;

    }

}
