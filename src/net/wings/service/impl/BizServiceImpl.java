package net.wings.service.impl;

import net.wings.dao.EmployeeDao;
import net.wings.dao.StatisticsDao;
import net.wings.dao.TrainDao;
import net.wings.domain.*;
import net.wings.exception.OutOfLimitException;
import net.wings.factory.DaoFactory;
import net.wings.service.BizService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class BizServiceImpl implements BizService {

    private TrainDao mTrainDao = DaoFactory.getInstance().createDao(TrainDao.class);
    private EmployeeDao mEmployeeDao = DaoFactory.getInstance().createDao(EmployeeDao.class);
    private StatisticsDao mStatisticsDao = DaoFactory.getInstance().createDao(StatisticsDao.class);

    @Override
    public void addTrain(Train c) {
        mTrainDao.add(c);
    }

    @Override
    public void deleteTrain(String id) {
        mTrainDao.delete(id);
    }

    @Override
    public void updateTrain(Train c) {
        mTrainDao.update(c);
    }

    @Override
    public Train findTrain(String id) {
        return mTrainDao.find(id);
    }

    @Override
    public List getAllTrain() {
        return mTrainDao.getAll();
    }

    @Override
    public int getTrainCount() {
        return getAllTrain().size();
    }


    @Override
    public void addEmployee(Employee c) {
        String count = mStatisticsDao.getTrainsCount(c.getTrain_id());
        String limit = findTrain(c.getTrain_id()).getMlimit();
        System.out.println("limit ::" + limit);
        System.out.println("count ::" + count);
        if (Integer.valueOf(count) >= Integer.valueOf(limit)) {
            throw new OutOfLimitException("out of limit");
        }
        mEmployeeDao.add(c);
    }

    @Override
    public void deleteEmployee(String id) {
        mEmployeeDao.delete(id);
    }

    @Override
    public void updateEmployee(Employee c) {
        mEmployeeDao.update(c);
        System.out.println("updateEmployee ");
    }

    @Override
    public Employee findEmployee(String id) {
        return mEmployeeDao.find(id);
    }

    @Override
    public List getAllEmployee() {
        return mEmployeeDao.getAll();
    }

    @Override
    public int getEmployeeCount() {
        return getAllEmployee().size();
    }

    @Override
    public EmployeePageBean pageQuery(QueryInfo info) {
        EmployeePageBean pageBean = new EmployeePageBean();

        QueryEmployeeResult queryEmployeeResult = mEmployeeDao.pageQuery(
                info.getStartindex(), info.getPagesize());

        pageBean.setList(queryEmployeeResult.getList());
        pageBean.setTotalrecord(queryEmployeeResult.getTotalrecord());
        pageBean.setCurrentpage(info.getCurrentpage());

        System.out.println(info.getCurrentpage());
        pageBean.setPagesize(info.getPagesize());
        return pageBean;
    }

    @Override
    public List<StatisticsItem> getStatistics() {
        List<StatisticsItem> items = new ArrayList<>();
        List<Train> trainList = getAllTrain();
        for (Train train : trainList) {
            StatisticsItem item = new StatisticsItem();
            String id = train.getId();
            item.setId(id);
            item.setName(train.getName());
            item.setMlimit(train.getMlimit());
            String count = mStatisticsDao.getTrainsCount(id);
            item.setCount(count);
            items.add(item);
        }
        return items;
    }


}
