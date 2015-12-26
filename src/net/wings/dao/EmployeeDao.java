package net.wings.dao;

import net.wings.domain.*;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public interface EmployeeDao {
    void add(Employee item);

    void delete(String id);

    void update(Employee item);

    Employee find(String id);

    Employee findByName(String name);

    List<Employee> getAll();

    QueryEmployeeResult pageQuery(int startindex, int pagesize);
}
