/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import task.jpaexample.dao.PurchaseDao;
import task.jpaexample.model.PurchaseDTO;

public class JpaPurchaseDao  extends GenericJpaDao<PurchaseDTO, Long> implements PurchaseDao {
    @Override
    public List<PurchaseDTO> find_all_customer_purchase(String name, String lastname) {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> r = em.createNamedQuery("PurchaseDTO.find_all_customer_purchase", PurchaseDTO.class);
        r.setParameter("name", name);
        r.setParameter("lastname", lastname);
        return r.getResultList();
    }
    
    @Override
    public List<PurchaseDTO> Return_All_Purchase() {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> r = em.createNamedQuery("PurchaseDTO.Return_All_Purchase", PurchaseDTO.class);
        return r.getResultList();
    }
}
