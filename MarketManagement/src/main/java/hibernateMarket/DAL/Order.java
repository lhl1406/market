package hibernateMarket.DAL;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;

/**
 *
 * @author Tran Ngan
 */
@Data
@Entity
@Table(name="orders")

public class Order implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date Date;
    
    @Column
    private float Total;
    
    @Column
    private String Note;
            
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn (name = "CustomerID")
//    @MapsId
    private Customers customers;
    public Order() {
    }

//    private List<OrderDetail> orderdetail;
    public Order(int OrderID, Customers customer, Date Date, float Total, String Note) {
        this.OrderID = OrderID;
        this.customers = customer;
        this.Date = Date;
        this.Total = Total;
        this.Note = Note;
    }
    
    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }
     
    public Date getDate(){
        return Date;
    }
    
    public void setDate(Date Date) {
        this.Date = Date;
    }
    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    
    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
     public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    //@Transient
//    @ManyToMany
//    @JoinTable(name="orderdetail",
//        joinColumns = {@JoinColumn(name="OrderID" , referencedColumnName = "OrderID")},
//        inverseJoinColumns = {@JoinColumn(name="VegetableID" , referencedColumnName = "VegetableID") })
//    private List<Vegetable> vegetables;
        

//    @Transient
//    @OneToMany (mappedBy = "order")
//    private List<Orderdetail> orderdetail;

    
//        @OneToMany(mappedBy = "primaryKey.order",
//            cascade = CascadeType.ALL)
//        //private Set<Orderdetail> orderdetail = new HashSet<Orderdetail>();

}