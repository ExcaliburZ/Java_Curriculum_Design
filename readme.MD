
# Java课程设计计划书
##要求
企业新进员工培训管理系统
主要功能：  
（1）培训项目管理：①培训项目相关信息的录入，修改和删除；②培训项目信息的浏览查询.  
（2）报名管理：①培训报名信息的录入，修改；②报名情况的浏览、统计和查询。  
A）培训信息包括：培训编号，培训名称，培训地点，培训时间，限报人数等。  
B）培训报名信息包括：培训编号，姓名，性别，年龄，电话，培训项目编号等。 

##框架
* 采用MVC 三层架构模式
* 采用git作为版本控制工具,代码托管在Github上
* Model层使用jdbc+mysql方式,使用c3po连接池
* 各层之间使用接口通信,利用工厂设计模式实现解耦合


##实现

###1.搭建开发环境

1.1 导入数据库驱动

1.2 导入开发包
> jstl开发包


> log4j


>  beanutils

1.3 创建开发包

>         net.wings.domain
>         net.wings.dao
>         net.wings.dao.impl
>         net.wings.service
>         net.wings.service.impl
>         net.wings.web.UI
>         net.wings.web.controller
>         net.wings.utils
>         net.wings.exception
>         net.test
>         WEB-INF/jsp


2创建代表实体的库和表
   ```sql  

create database kcsj character set utf8 collate utf8_general_ci;

		create table train(
		  id varchar(40) primary key,
		  name varchar(40) not null Unquie,
          place varchar(40) not null,
		  during varchar(40) not null,
		  mlimit varchar(40) not null
		  );
		  
	create table employee(
		 id varchar(40) primary key,
		 name varchar(40) not null,
         gender varchar(4) not null,
		 age varchar(40) not null,
		 phone varchar(20),
		 train_id varchar(40),
		 train_name varchar(40),
		constraint train_name_FK foreign key(train_name) references train(name)
		  );
```


3 写实体

4 写dao层

5 写service层

6 写web层























