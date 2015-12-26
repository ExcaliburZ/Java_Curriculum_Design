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
<body >
<h1>用户管理系统</h1>
<%--<br/>--%>
<a href="${pageContext.request.contextPath}/addCustomerServlet" target="main">添加用户</a>
<a href="${pageContext.request.contextPath}/listCustomerServlet" target="main">查看用户</a>
</body>
</html>
