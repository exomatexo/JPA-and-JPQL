/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
@NamedQueries({
    @NamedQuery(name = "PurchaseDTO.find_all_customer_purchase", query = "select p from PurchaseDTO p where p.customer.firstName = :name and p.customer.lastName = :lastname"),
    @NamedQuery(name = "PurchaseDTO.Return_All_Purchase", query = "select distinct p from  PurchaseDTO p left join p.purchaseItems d"),
})
@Entity
@Table(name="PURCHASE", schema="APP")
public class PurchaseDTO extends AbstractDTO {
    @ManyToOne
    private CustomerDTO customer;
    private String address;
    @ManyToOne
    private Delivery_companyDTO delivery_company;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_of_transaction; 
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();

    public Delivery_companyDTO getDelivery_company() {
        return delivery_company;
    }

    public void setDelivery_company(Delivery_companyDTO delivery_company) {
        this.delivery_company = delivery_company;
    }

    public Date getDate() {
        return date_of_transaction;
    }

    public void setDate(Date date) {
        this.date_of_transaction = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }
    
}
