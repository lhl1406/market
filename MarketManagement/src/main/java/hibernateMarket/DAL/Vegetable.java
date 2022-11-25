
package hibernateMarket.DAL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table
public class Vegetable implements Serializable {
    @Id
    private int VegetableID;
    @Column 
    private String VegetableName;
    @Column
    private String Unit;
    @Column
    private int Amount;
    @Column 
    private String Image;
    @Column
    private Double Price;
    
//    @ManyToOne
//    @JoinColumn(name="CatagoryID")
//    private Category catagory;
    
//    @Transient
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vegetables")
//    private List<Order> order;

//    @Transient
//    @OneToMany (mappedBy = "vegetable")
//    private List<Orderdetail> orderdetail;
    
    @OneToMany(mappedBy = "primaryKey.vegetable",
            cascade = CascadeType.ALL)
    private Set<Orderdetail> userGroups = new HashSet<Orderdetail>();
}
