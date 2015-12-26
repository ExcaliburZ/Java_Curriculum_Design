
使用自定义框架改写

使用DBCP连接池优化

10.20
 实现分页数据显示


1搭建开发环境


    1.1 导入数据库驱动
    1.2 导入开发包
        jstl开发包
        log4j
        beanutils

    1.3 创建开发包
        net.wings.domain
        net.wings.dao
        net.wings.dao.impl
        net.wings.service
        net.wings.service.impl
        net.wings.web.UI
        net.wings.web.controller
        net.wings.utils
        net.wings.exception
        net.test

        WEB-INF/jsp


2创建代表实体的库和表
    create database day14_customer character set utf8 collate utf8_general_ci;
          use day14_customer;
          create table customer
          (
              id varchar(40) primary key,
              name varchar(40) not null,
              gender varchar(4) not null,
              birthday date,
              cellphone varchar(20),
              email varchar(40),
              preference varchar(255),
              type varchar(100) not null,
              description varchar(255)
          );

3 写实体

4 写dao层

5 写service层

6 写web层























