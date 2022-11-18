/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatebanhang.DAL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.*;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Table
public class Customer{

    @Id
    @GeneratedValue 
    private int CustomerID;
    @Column
    private String FullName;
    @Column
    private String Password;
    @Column
    private String Address;
    @Column
    private String City;
    
    public Customer(){
        
    }

    public Customer(int CustomerID, String FullName, String Password, String Address, String City) {
        super();
        this.CustomerID = CustomerID;
        this.FullName = FullName;
        this.Password = Password;
        this.Address = Address;
        this.City = City;
    }

    public Customer(String FullName, String Password, String Address, String City) {
        super();
        this.FullName = FullName;
        this.Password = Password;
        this.Address = Address;
        this.City = City;
    }
    
     public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    
    
//    @OneToMany (mappedBy = "catagory")  
//    private List<Vegetable> listVegetable;
// 
    @Override
    public String toString()
    {
        return "Customer [Ma=" + CustomerID + ", Ten=" + FullName + ", Matkhau=" + Password
			+ ", Diachi=" + Address + ", Thanhpho=" + City + "]";
    }
}


