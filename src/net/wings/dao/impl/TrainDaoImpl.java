package net.wings.dao.impl;

import net.wings.dao.TrainDao;
import net.wings.domain.Train;
import net.wings.exception.DaoException;
import net.wings.utils.JdbcUtils;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class TrainDaoImpl implements TrainDao {
    @Override
    public void add(Train item) {
        try {
            String sql = "insert into train" +
                    "(id,name,place,during,mlimit)" +
                    " values(?,?,?,?,?)";
            Object params[] = {
                    item.getId(),
                    item.getName(),
                    item.getPlace(),
                    item.getDuring(),
                    item.getMlimit()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "delete from train where id=?";
            Object params[] = {id};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Train item) {
        try {
            String sql = "update train set name=?,place=?,during=?,mlimit=? where id=?";

            Object params[] = {
                    item.getName(),
                    item.getPlace(),
                    item.getDuring(),
                    item.getMlimit(),
                    item.getId()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Train find(String id) {
        try {
            String sql = "select * from train where id=?";
            Object params[] = {id};
            return (Train) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(Train.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Train> getAll() {
        try {
            String sql = "select * from train";
            Object params[] = {};
            return (List<Train>) JdbcUtils.select(sql,
                    new net.wings.utils.BeanListHandler(Train.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
