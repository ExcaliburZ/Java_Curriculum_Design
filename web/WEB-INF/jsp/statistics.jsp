<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://wing.net" %>
<html>
<head>
    <title>统计信息</title>
    <style type="text/css">
        body table {
            font-size: 24px;
            font-family: "黑体";
            margin-top: 100px;
        }

        .even {
            background-color: lavenderblush;
        }

        .odd {
            background-color: lightskyblue;
        }

        tr:hover {
            background-color: lawngreen;
        }

        .text {
            width: 30px;
            height: 30px;
            font-family: "黑体";
            font-size: 24px;
        }

        #target {
            width: 30px;
            height: 30px;
            font-family: "黑体";
            font-size: 24px;
        }

        #input {
            width: 30px;
            height: 30px;
            font-family: "黑体";
            font-size: 24px;
        }

        #button {
            width: 35px;
            height: 30px;
            margin-top: -1px;
            font-size: 24px;
            font-family: "黑体";
        }
    </style>
</head>
<body style="text-align: center">
<table border="1px" width="70%" align="center">
    <tr>
        <td>项目名称</td>
        <td>限制人数</td>
        <td>报名人数</td>
        <td>剩余名额</td>
    </tr>
    <c:forEach items="${requestScope.statistics}" var="str" varStatus="status">
        <tr class="${status.count%2==0?'even':'odd'}">
            <td>${fn:filter(str.name)}</td>
            <td>${str.mlimit}</td>
            <td>${str.count}</td>
            <td>${str.mlimit-str.count}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>项目总数</td>
        <td>${trainCount}</td>
        <td>员工人数</td>
        <td>${employeeCount}</td>
    </tr>
</table>
<br/><br/><br/><br/><br/><br/><br/>
</body>
</html>
