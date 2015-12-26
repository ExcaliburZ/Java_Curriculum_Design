package net.test;

import net.wings.dao.StatisticsDao;
import net.wings.dao.impl.StatisticsDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class StatisticsDaoTest {
    private StatisticsDao dao = new StatisticsDaoImpl();

    @Test
    public void getAll() {
        String count = dao.getTrainsCount("1");
        System.out.println("aa");
    }
}
