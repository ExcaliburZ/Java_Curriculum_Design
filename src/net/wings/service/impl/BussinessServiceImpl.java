package net.wings.service.impl;

import net.wings.dao.CustomerDao;
import net.wings.dao.impl.CustomerDaoImpl;
import net.wings.domain.PageBean;
import net.wings.domain.QuertResult;
import net.wings.domain.QueryInfo;
import net.wings.domain.customer;

import java.util.List;

public class BussinessServiceImpl implements net.wings.service.BussinessService {
    CustomerDao dao = new CustomerDaoImpl();

    @Override
    public void addCustomer(customer c) {
        dao.add(c);
    }

    @Override
    public void delectCustomer(String id) {
        dao.delete(id);
    }

    @Override
    public void updateCustomer(customer c) {
        dao.update(c);
    }

    @Override
    public customer find(String id) {
        return dao.find(id);
    }

    @Override
    public List<customer> getAllCustomer() {
        return dao.getAll();
    }

    public PageBean pageQuery(QueryInfo info){

        PageBean pageBean = new PageBean();
        QuertResult qr =dao.pageQuery(info.getStartindex(),info.getPagesize());
        pageBean.setList(qr.getList());
        pageBean.setTotalrecord(qr.getTotalrecord());
        pageBean.setCurrentpage(info.getCurrentpage());
        System.out.println(info.getCurrentpage());
        pageBean.setPagesize(info.getPagesize());
        return pageBean;
    }
}
