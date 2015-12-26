<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function makepre() {
            var pres = document.getElementsByName("pre");
            var preference = "";
            for (var i = 0; i < pres.length; i++) {
                var input = pres[i];
                if (input.checked == true) {
                    preference = preference + input.value + ",";
                }
            }
            preference = preference.substr(0, preference.length - 1);
            var form = document.getElementById("form");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "preference";
            input.value = preference;
            form.appendChild(input);
            return true;
        }
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
    <style>
        table {
            font-size: 24px;
            margin-top: 80px;
            font-family: "黑体";
        }

        input {
            font-size: 24px;
            font-family: "黑体";
        }
    </style>
    <%
        String gender[] = {"男", "女"};
        request.setAttribute("gender", gender);
    %>
</head>
<body style="text-align: center">
<form action="${pageContext.request.contextPath}/AddEmployeeServlet" method="post" onsubmit="return makepre()"
      id="form">
    <table align="center" border="1" width="30%">
        <tr>
            <td>员工姓名</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td style="text-align: left">
                <c:forEach var="str" items="${requestScope.gender}">
                    <input type="radio" name="gender" value="${str}">${str}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>年纪</td>
            <td>
                <input name="age" type="text">
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input name="phone" type="text">
            </td>
        </tr>
        <tr>
            <td>参与项目</td>
            <td>
                <select name="train_id">
                    <c:forEach items="${requestScope.trains}" var="p">
                        <option value="${p.id}" selected="${p.id==requestScope.trains[0].id?'selected':''}">
                                ${p.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="添加客户">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

