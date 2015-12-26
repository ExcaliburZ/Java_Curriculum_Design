<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://wing.net" %>
<html>
<head>
    <title>列出所有客户</title>
    <script type="text/javascript">
        function del(id) {
            if (window.confirm("你确认要删除吗？")) {
                window.location.href = "${pageContext.request.contextPath}/DeleteCustomerServlet?id=" + id;
            }
        }
    </script>

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
        <td>客户姓名</td>
        <td>性别</td>
        <td>生日</td>
        <td>联系电话</td>
        <td>邮箱</td>
        <td>爱好</td>
        <td>类型</td>
        <td>简介</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pagebean.list}" var="str" varStatus="status">
        <tr class="${status.count%2==0?'even':'odd'}">
            <td>${fn:filter(str.name)}</td>
            <td>${str.gender}</td>
            <td>${str.birthday}</td>
            <td>${str.cellphone}</td>
            <td>${str.email}</td>
            <td>${fn:filter(str.preference)}</td>
            <td>${str.type}</td>
            <td>${fn:filter(str.description)}</td>
            <td>
                <a href="${pageContext.request.contextPath}/UpdateCustomerServlet?id=${str.id}">修改</a>
                <a href="javascript:void(0)" onclick="return del('${str.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/><br/><br/><br/><br/><br/><br/>
<script type="text/javascript">
    function gopage(targetpage) {
        if (targetpage < 0 || targetpage != parseInt(targetpage) || targetpage > ${pagebean.totalpage}) {
            document.getElementById("target").value = "";

        } else {
            var pagesize = document.getElementById("input").value;
            if (pagesize < 0 || pagesize != parseInt(pagesize)) {
                pagesize = 5;
            }
            window.location.href = "${pageContext.request.contextPath}/listCustomerServlet?currentpage=" + targetpage + "&pagesize=" + pagesize;
        }
    }
</script>
<div style="font-size: 24px">
    共[${pagebean.totalrecord}]条记录，每页
    <input type="text" id="input" value="${pagebean.pagesize}" maxlength="2" onchange="gopage('1')">
    条,共[${pagebean.totalpage}]页，当前第[${pagebean.currentpage}]页
    &nbsp;&nbsp;&nbsp;
    <c:if test="${pagebean.currentpage > 1}">
        <a href="javascript:void(0)" onclick="gopage(${pagebean.currentpage}-1)">
            上一页
        </a>
    </c:if>
    <c:forEach items="${pagebean.pagebar}" var="page">
        <c:if test="${page ==pagebean.currentpage}">
            <span style="color: red">${page}</span>
        </c:if>
        <c:if test="${page !=pagebean.currentpage}">
            <a href="javascript:void(0)" onclick="gopage(${page})">${page}</a>
        </c:if>
    </c:forEach>
    <c:if test="${pagebean.currentpage < pagebean.totalpage}">
        <a href="javascript:void(0)" onclick="gopage(${pagebean.currentpage}+1)">下一页</a>
    </c:if>

    <input type="text" id="target">
    <input type="button" id="button" value="Go" onclick="gopage(document.getElementById('target').value)">
</div>
</body>
</html>
