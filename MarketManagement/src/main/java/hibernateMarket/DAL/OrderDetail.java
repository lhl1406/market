/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateMarket.DAL;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author VIVOBOOK
 */
@Data
@Table (name = "orderdetail")
public class OrderDetail {
    @ManyToOne
    @JoinColumn (name = "OrderID")
    private Order order;
    
    private int Quantity;
    private float Price;
}
