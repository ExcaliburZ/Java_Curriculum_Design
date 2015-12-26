package net.test;

import net.wings.dao.impl.EmployeeDaoImpl;
import net.wings.dao.impl.TrainDaoImpl;
import net.wings.domain.Employee;
import net.wings.domain.QueryEmployeeResult;
import net.wings.domain.Train;
import org.junit.Test;

import java.util.List;

/**
 * Created by wing on 2014/10/18.
 */
public class EmployeeTest {
    EmployeeDaoImpl dao = new EmployeeDaoImpl();
    Employee c = new Employee("99", "99", "男", "11", "111", "1","he");

    @Test
    public void add() {
        for (int i = 1; i < 100; i++) {
            Employee item = new Employee("100"+i, "Zhange"+i, "男", "22", "189", "1",".net");
            dao.add(item);
        }
    }
    @Test
    public void addOne() {
        dao.add(c);
    }

    @Test
    public void addError() {
        Employee item = new Employee("888", "a", "male", "11", "111", "2","he");
        dao.add(item);
    }
    @Test
    public void delete() {
        dao.delete("3");
    }

    @Test
    public void update() {
        dao.update(c);
    }

    @Test
    public void find() {
        Employee train = dao.find("1");
        System.out.println("aa");
    }

    @Test
    public void findName() {
        Employee train = dao.findByName("zzz");
        System.out.println("aa");
    }


    @Test
    public void getAll() {
        List list = dao.getAll();
        System.out.println("aa");
    }

    @Test
    public void getPage() {
        QueryEmployeeResult queryEmployeeResult = dao.pageQuery(1, 10);
        System.out.println("aa");
    }



}
