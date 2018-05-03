/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import task.jpaexample.dao.ProductDao;
import task.jpaexample.model.ProductDTO;

public class JpaProductDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
     @Override
    public List<ProductDTO> findProducts_PriceBetween(Double price1, Double price2 ) {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findProducts_PriceBetween",ProductDTO.class);
         q.setParameter("price1",price1);
         q.setParameter("price2",price2);
        return q.getResultList();
    }

    @Override
    public List<ProductDTO> findProduct_MaxPrice() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findProduct_MaxPrice",ProductDTO.class);
        return q.getResultList();   
    }
    @Override
    public List<ProductDTO> findProduct_Leastbought(){
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.findProduct_Leastbought", ProductDTO.class);
        return r.getResultList();
    }
    
    @Override
    public List<ProductDTO> findProduct_Buymost() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.findProduct_Buymost", ProductDTO.class);
        return r.getResultList();
    }

    @Override
    public void changePrice(Double how_much) {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO>  r = em.createNamedQuery("ProductDTO.changePrice", ProductDTO.class);
        r.setParameter("how_much", how_much/100);
        em.getTransaction().begin();
        r.executeUpdate();
        em.getTransaction().commit();
    }
}
