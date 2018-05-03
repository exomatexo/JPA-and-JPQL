/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQuery;


@NamedQuery(name = "CustomerDTO.find_lastname", query="select c from CustomerDTO c where c.lastName= :lastName")
@Entity
@Table(name="CUSTOMER", schema="APP")
public class CustomerDTO extends AbstractDTO {
   
    private String firstName;
    private String lastName;
    private String email;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "["+getId()+","+firstName+","+lastName+","+email+"]";
    }
}
