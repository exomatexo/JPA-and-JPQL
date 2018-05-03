/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao;
import java.util.List;
import task.jpaexample.model.PurchaseDTO;

public interface PurchaseDao  extends GenericDao<PurchaseDTO,Long>  {
    public List<PurchaseDTO> find_all_customer_purchase(String name, String lastname);
    public List<PurchaseDTO> Return_All_Purchase();
}

