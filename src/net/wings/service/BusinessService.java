package net.wings.service;

import net.wings.domain.PageBean;
import net.wings.domain.QueryInfo;
import net.wings.domain.customer;

import java.util.List;

/**
 * Created by wing on 2014/10/18.
 */
public interface BusinessService {
    void addCustomer(customer c);

    void delectCustomer(String id);

    void updateCustomer(customer c);

    customer find(String id);

    List getAllCustomer();

    public PageBean pageQuery(QueryInfo info);
}
