package net.test;

import net.wings.dao.impl.SelectClazzDaoImpl;
import net.wings.dao.impl.TrainDaoImpl;
import net.wings.dao.impl.UserDaoImpl;
import net.wings.domain.Clazz;
import net.wings.domain.SelectClazz;
import net.wings.domain.Train;
import net.wings.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by wing on 2014/10/18.
 */
public class DaoTest_kcsj {
    TrainDaoImpl dao = new TrainDaoImpl();
    Train c = new Train("1", "123", "1", "2", "3");

    @Test
    public void add() {
        dao.add(c);
    }

    @Test
    public void delete() {
        dao.delete("1");
    }

    @Test
    public void update() {
        c.setName("he");
        dao.update(c);
    }

    @Test
    public void find() {
        Train train = dao.find("1");
        System.out.println("aa");
    }

    @Test
    public void getAll() {
        List list = dao.getAll();
        System.out.println("aa");
    }

    @Test
    public void testRegister() {
        UserDaoImpl dao = new UserDaoImpl();
        User byNumber = dao.findByNumber("13477126");
        User wing_zjq = dao.findByAccount("wing_zjq");
        System.out.println("zjq");
    }

    @Test
    public void testSelect() {
        SelectClazz selectClazz = new SelectClazz
                ("wing_zjq", "13477126", "192916f3-ef74-402d-ad8e-d196ca1c5d3f", "ZhangSan");
        SelectClazzDaoImpl dao = new SelectClazzDaoImpl();
        dao.add(selectClazz);
    }
    @Test
    public void testMyClass() {
        SelectClazzDaoImpl dao = new SelectClazzDaoImpl();
        List<Clazz> clazzList = dao.getClazzListByStudentAccount("wing_zjq");
        System.out.println("zjq");
    }
}
