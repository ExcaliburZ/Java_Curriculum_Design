<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://wing.net" %>
<html>
<head>
    <title>列出所有培训项目</title>
    <script type="text/javascript">
        function del(id) {
            if (window.confirm("删除这个培训项目,会丢失与之相关的报名信息." +
                            "   你确定要删除吗?")) {
                window.location.href = "${pageContext.request.contextPath}/DeleteTrainServlet?id=" + id;
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
        <td>项目名称</td>
        <td>地点</td>
        <td>时间</td>
        <td>限制人数</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.trains}" var="str" varStatus="status">
        <tr class="${status.count%2==0?'even':'odd'}">
            <td>${fn:filter(str.name)}</td>
            <td>${str.place}</td>
            <td>${str.during}</td>
            <td>${str.mlimit}</td>
            <td>
                <a href="${pageContext.request.contextPath}/UpdateTrainServlet?id=${str.id}">修改</a>
                <a href="javascript:void(0)" onclick="return del('${str.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/><br/><br/><br/><br/><br/><br/>
</body>
</html>
