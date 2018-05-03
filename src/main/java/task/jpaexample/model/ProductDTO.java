/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQueries({
  @NamedQuery(name = "ProductDTO.findProducts_PriceBetween",query="select p from ProductDTO p where p.price between :price1 and :price2"),
  @NamedQuery(name = "ProductDTO.findProduct_MaxPrice",query="select p from ProductDTO p where p.price=(select max (pp.price) from ProductDTO pp) "),
  @NamedQuery(name = "ProductDTO.findProduct_Leastbought", query = "select p from ProductDTO p where p.id not in (select pi.product.id from PurchaseItemDTO pi)"),
  @NamedQuery(name = "ProductDTO.findProduct_Buymost", query = "select p from ProductDTO p where p.id in(select pi.product.id from PurchaseItemDTO pi group by pi.product.id having SUM(pi.quantity)>=ALL(select SUM(pi2.quantity) from PurchaseItemDTO pi2 group by pi2.product.id))"),
  @NamedQuery(name = "ProductDTO.changePrice", query = "update ProductDTO p set p.price = p.price + p.price * :how_much"),
})
@Entity
@Table(name="PRODUCT", schema="APP")
public class ProductDTO extends AbstractDTO {
   
    private String name;
    private Double price;

    public ProductDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

     @Override
    public String toString() {
        return "["+getId()+","+name+","+price;
    }
}
