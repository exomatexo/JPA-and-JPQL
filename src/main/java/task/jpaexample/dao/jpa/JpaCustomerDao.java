/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import task.jpaexample.dao.CustomerDao;
import task.jpaexample.model.CustomerDTO;

public class JpaCustomerDao extends GenericJpaDao<CustomerDTO, Long> implements CustomerDao {   

    @Override
    public List<CustomerDTO> find_lastname(String lastName) {
        EntityManager em = getEntityManager();
        TypedQuery<CustomerDTO> q;
        q = em.createNamedQuery("CustomerDTO.find_lastname",CustomerDTO.class);
        q.setParameter("lastName", lastName);
        return q.getResultList(); 
       }
    
}
