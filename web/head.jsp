<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        body {
            margin: 0px;
            padding: 0px;
            overflow-x: hidden;
            overflow-y: hidden;
            text-align: center;
            font-size: 36px;
            color: lightskyblue;
            font-family: "楷体";
        }
    </style>
</head>
<body>
<h1>企业新进员工培训管理系统</h1>
<%--<br/>--%>
<a href="${pageContext.request.contextPath}/AddTrainServlet" target="main">添加培训项目</a>
<a href="${pageContext.request.contextPath}/ListTrainServlet" target="main">查看培训项目</a>
<a href="${pageContext.request.contextPath}/AddEmployeeServlet" target="main">添加员工</a>
<a href="${pageContext.request.contextPath}/ListEmployeeServlet" target="main">查看员工</a>
<a href="${pageContext.request.contextPath}/StatisticsServlet" target="main">统计信息</a>
</body>
</html>
