/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao;
import java.util.List;
import task.jpaexample.model.ProductDTO;

public interface ProductDao extends GenericDao<ProductDTO,Long>  {
    public List<ProductDTO> findProducts_PriceBetween(Double price1,Double price2);
    public List<ProductDTO> findProduct_MaxPrice();
    public List<ProductDTO> findProduct_Leastbought();
    public List<ProductDTO> findProduct_Buymost();
    public void changePrice(Double how_much);
    
}
