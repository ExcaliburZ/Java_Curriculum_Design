package net.wings.dao;

import net.wings.domain.QuertResult;
import net.wings.domain.customer;

import java.util.List;

/**
 * Created by wing on 2014/10/18.
 */
public interface CustomerDao {
    void add(customer c);

    void delete(String id);

    void update(customer c);

    customer find(String id);

    List<customer> getAll();

    QuertResult pageQuery(int startindex, int pagesize);
}
