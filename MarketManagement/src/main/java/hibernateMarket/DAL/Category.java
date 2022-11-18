
package hibernateMarket.DAL;

import java.io.Serializable;
import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Category implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int CatagoryID;
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

    /**
     * @return the CatagoryID
     */
    public int getCatagoryID() {
        return CatagoryID;
    }

    /**
     * @param CatagoryID the CatagoryID to set
     */
    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the listVegetable
     */
    public List<Vegetable> getListVegetable() {
        return listVegetable;
    }

    /**
     * @param listVegetable the listVegetable to set
     */
    public void setListVegetable(List<Vegetable> listVegetable) {
        this.listVegetable = listVegetable;
    }
    
}
