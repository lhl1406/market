
package hibernateMarket.DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Category implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int CatagoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    
    @OneToMany (mappedBy = "catagory")  
    private List<Vegetable> listVegetable;
 
    @Override
    public String toString()
    {
        return this.getName();
    }

    public int getCatagoryID() {
        return CatagoryID;
    }

    
    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }
    
    
    public String getName() {
        return Name;
    }

    
    public void setName(String Name) {
        this.Name = Name;
    }

    
    public String getDescription() {
        return Description;
    }

    
    public void setDescription(String Description) {
        this.Description = Description;
    }

    
    public List<Vegetable> getListVegetable() {
        return listVegetable;
    }

    
    public void setListVegetable(List<Vegetable> listVegetable) {
        this.listVegetable = listVegetable;
    }
    
    
    
}
