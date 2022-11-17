package hibernateMarket.DAL;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="Order1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderID;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "CustomerID")
    private Customers customer;
    
    @Temporal(TemporalType.DATE)
    private Date Date;
    
    @Column
    private float Total;
    
    @Column
    private String Note;
    
    public int Note(){
        return this.OrderID;
    }
    
    @OneToMany (mappedBy = "order")
    private List<OrderDetail> orderdetail;

//    public Order(Customers CusID, Date date2, float total, String note) {
//        this.customer = CusID;
//        this.Date = date2;
//        this.Total = total;
//        this.Note = note;
//    }
}
