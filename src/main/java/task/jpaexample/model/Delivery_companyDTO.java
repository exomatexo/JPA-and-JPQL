/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.jpaexample.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author exomat
 */
@Entity
@Table(name="Delivery_company", schema="APP")
public class Delivery_companyDTO extends AbstractDTO {
    private String Name; 
    private String Address;
    private Integer  Phone_number;
    private String mail; 
    @OneToMany(mappedBy = "Delivery_company", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private final List<PurchaseDTO> purchase = new ArrayList();
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Integer getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(Integer Phone_number) {
        this.Phone_number = Phone_number;
    }

   
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
}
