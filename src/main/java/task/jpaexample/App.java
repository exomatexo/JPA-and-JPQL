/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.jpaexample;

import java.util.Date;
import java.util.List;
import task.jpaexample.dao.CustomerDao;
import task.jpaexample.dao.Delivery_companyDao;
import task.jpaexample.dao.ProductDao;
import task.jpaexample.dao.PurchaseDao;
import task.jpaexample.dao.jpa.JpaCustomerDao;
import task.jpaexample.dao.jpa.JpaDelivery_companyDao;
import task.jpaexample.dao.jpa.JpaProductDao;
import task.jpaexample.dao.jpa.JpaPurchaseDao;
import task.jpaexample.model.CustomerDTO;
import task.jpaexample.model.Delivery_companyDTO;
import task.jpaexample.model.ProductDTO;
import task.jpaexample.model.PurchaseDTO;
import task.jpaexample.model.PurchaseItemDTO;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        * testing!! 
        */
        CustomerDao cdao = new JpaCustomerDao();
        ProductDao pdao = new JpaProductDao();
        PurchaseDao dao = new JpaPurchaseDao();
        Delivery_companyDao dcdao = new JpaDelivery_companyDao();
        // create client 
        CustomerDTO c1 = new CustomerDTO();
        c1.setFirstName("jan");
        c1.setLastName("cebulak");
        c1.setEmail("j.n@gmial.com");
        cdao.save(c1);
        // create delivery company 
        Delivery_companyDTO d1= new Delivery_companyDTO();
        d1.setName("DHL");
        d1.setAddress("adress1");
        d1.setMail("1234@gmail.com");
        d1.setPhone_number(60779222);
        dcdao.save(d1);
        // create some product 
        ProductDTO p1 = new ProductDTO();
        p1.setName("kosiarka");
        p1.setPrice(999.99);
        pdao.save(p1);
        // create purchase for test 
        PurchaseDTO pe = new PurchaseDTO();
        pe.setCustomer(c1);
        PurchaseItemDTO pi = new PurchaseItemDTO();
        pi.setProduct(p1);
        pi.setQuantity(7);
        pe.addPurchaseItem(pi);
        pe.setAddress("Elk");
        pe.setDate(new Date());
        pe.setDelivery_company(d1);
        dao.save(pe);     
        c1.setFirstName("janusz");
        cdao.update(c1);
        pi.setQuantity(50);
        pe.addPurchaseItem(pi);
        dao.update(pe);
        // test 1a) find customer 
        for(CustomerDTO c:cdao.find_lastname("cebulak")){
            System.out.println(c);
        } 
        // test 1b) find product between some prices
        Double price1 = 500.0, price2 = 1100.0;
        List<ProductDTO> findProducts_PriceBetween = pdao.findProducts_PriceBetween(price1, price2);
        for( ProductDTO d : findProducts_PriceBetween)
            System.out.println(d.getName() + ", " + d.getPrice());
        // test 1c) most expensive product
        List<ProductDTO> findProduct_MaxPrice = pdao.findProduct_MaxPrice();
        for( ProductDTO i : findProduct_MaxPrice)
            System.out.println(i.getName() + ", " + i.getPrice());
        // test 1d) all purchase from one customer
        String name = "janusz", lastname = "cebulak";
        List<PurchaseDTO> find_all_customer_purchase = dao.find_all_customer_purchase(name, lastname);
        for( PurchaseDTO p : find_all_customer_purchase)
            System.out.println( p.getCustomer().getFirstName() + ", " + p.getAddress() + ", " + p.getDate());
        
       // test 2a) product with no purchase 
        List<ProductDTO> findProduct_Leastbought = pdao.findProduct_Leastbought();
        for( ProductDTO p : findProduct_Leastbought)
            System.out.println(p.getName() + ", " + p.getPrice());
        
        // test 2b) product which is most popular  
        List<ProductDTO> findProduct_Buymost = pdao.findProduct_Buymost();
        for( ProductDTO p : findProduct_Buymost)
            System.out.println(p.getName() + ", " +p.getPrice());
        // test 2c) change price; 
        //pdao.changePrice(15.0);
        // test 3 return all purchase 
        PurchaseDTO pe2 = new PurchaseDTO();
        pe2.setCustomer(c1);
        PurchaseItemDTO product2 = new PurchaseItemDTO();
        product2.setProduct(p1);
        product2.setQuantity(33);
        Date d12 = new Date();
        pe2.setDate(d12);
        pe2.setAddress("Białystok");
        pe2.addPurchaseItem(product2);
        pe2.setDelivery_company(d1);
        dao.save(pe2);
        
        pe2.addPurchaseItem(pi);
        dao.update(pe2);
        List<PurchaseDTO> Return_All_Purchase = dao.Return_All_Purchase();
        for( PurchaseDTO p : Return_All_Purchase)
            System.out.println(p.getId() + ", " + p.getAddress());
        
        
        
    }

}
