package net.wings.dao.impl;

import net.wings.dao.StatisticsDao;
import net.wings.domain.Employee;
import net.wings.utils.IntHandler;
import net.wings.utils.JdbcUtils;

/**
 * Created by wing on 2015/12/26.
 */
public class StatisticsDaoImpl implements StatisticsDao {
    @Override
    public String getTrainsCount(String train_id) {
        String sql = "select count(*) from employee where train_id=?";
        Object params[] = {train_id};
        int totalRecord = (Integer) JdbcUtils.select(sql, params, new IntHandler());
        return String.valueOf(totalRecord);
    }
}
