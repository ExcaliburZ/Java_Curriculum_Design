
ʹ���Զ����ܸ�д

ʹ��DBCP���ӳ��Ż�

10.20
 ʵ�ַ�ҳ������ʾ


1���������


    1.1 �������ݿ�����
    1.2 ���뿪����
        jstl������
        log4j
        beanutils

    1.3 ����������
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


2��������ʵ��Ŀ�ͱ�
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

3 дʵ��

4 дdao��

5 дservice��

6 дweb��























