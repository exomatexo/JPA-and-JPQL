/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao;
import java.util.List;
import task.jpaexample.model.CustomerDTO;

public interface CustomerDao extends GenericDao<CustomerDTO,Long>  {
    public List<CustomerDTO> find_lastname (String lastName); 
}
