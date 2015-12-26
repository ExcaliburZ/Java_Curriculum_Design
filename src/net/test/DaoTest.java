package net.test;

import net.wings.dao.impl.CustomerDaoImpl;
import net.wings.domain.customer;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by wing on 2014/10/18.
 */
public class DaoTest {
    CustomerDaoImpl dao = new CustomerDaoImpl();
    customer c =new customer("33","1","1",new Date(),"1","1","1","1","1");
    @Test
    public void add(){

        dao.add(c);
   }
    @Test
    public void delect(){
        dao.delete("33");
    }
    @Test
    public void update(){
        c.setName("he");
        c.setEmail("bbb@cc.com");
        dao.update(c);
    }
    @Test
    public void find(){
        System.out.println(dao.find("33"));
//        System.out.println(dao.find("2"));
//        dao.getAll().get(1).getPreference();
        List list =dao.getAll();
//        customer c = (customer) list.get(1);
//        System.out.println(c.getPreference());
    }

}
