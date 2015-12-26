package net.wings.service;

import net.wings.domain.*;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public interface BizService {

    void addTrain(Train c);

    void deleteTrain(String id);

    void updateTrain(Train c);

    Train findTrain(String id);

    List getAllTrain();

    int getTrainCount();

    void addEmployee(Employee c);

    void deleteEmployee(String id);

    void updateEmployee(Employee c);

    Employee findEmployee(String id);

    List getAllEmployee();

    int getEmployeeCount();

    public EmployeePageBean pageQuery(QueryInfo info);

    List<StatisticsItem> getStatistics();

}
