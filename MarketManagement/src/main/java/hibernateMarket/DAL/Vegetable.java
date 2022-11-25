
package hibernateMarket.DAL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Vegetable implements Serializable {
    @Id
    private int VegetableID;
    //get last ID
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
    
    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private Category catagory;

    /**
     * @return the VegetableID
     */
    public int getVegetableID() {
        return VegetableID;
    }

    /**
     * @param VegetableID the VegetableID to set
     */
    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }

    /**
     * @return the VegetableName
     */
    public String getVegetableName() {
        return VegetableName;
    }

    /**
     * @param VegetableName the VegetableName to set
     */
    public void setVegetableName(String VegetableName) {
        this.VegetableName = VegetableName;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    /**
     * @return the Amount
     */
    public int getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Image
     */
    public String getImage() {
        return this.Image;
    }

    /**
     * @param Image the Image to set
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    /**
     * @return the Price
     */
    public Double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    /**
     * @return the catagory
     */
    public Category getCatagory() {
        return catagory;
    }

    /**
     * @param catagory the catagory to set
     */
    public void setCatagory(Category catagory) {
        this.catagory = catagory;
    }
}
