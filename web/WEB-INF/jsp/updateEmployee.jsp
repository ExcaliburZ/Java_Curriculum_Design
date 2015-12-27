<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
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

        textarea {
            font-size: 24px;
            font-family: "黑体";
        }
    </style>
    <title></title>
    <script type="text/javascript" charset="utf-8">
        function makepre() {
            var preference = "";
            var pres = document.getElementsByName("pre");
            for (var i = 0; i < pres.length; i++) {
                var input = pres[i];
                if (input.checked == true) {
                    preference = preference + input.value + ",";
                }
            }
            preference = preference.substr(0, preference.length - 1);
            var form = document.getElementById("hehe");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "preference";
            input.value = preference;
            form.appendChild(input);
            return true;
        }
    </script>
    <%
        String gender[] = {"男", "女"};
        request.setAttribute("gender", gender);
    %>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
</head>
<body style="text-align: center">
<form action="${pageContext.request.contextPath}/UpdateEmployeeServlet" method="post" onsubmit="return makepre()"
      id="hehe">
    <input type="hidden" value="${employee.id}" name="id">
    <table align="center" border="1" width="30%">
        <tr>
            <td>员工姓名</td>
            <td>
                <input type="text" name="name" value="${employee.name}">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td style="text-align: left">
                <c:forEach var="str" items="${gender}">
                    <input type="radio" name="gender" value="${str}" ${employee.gender == str?'checked':''}>
                    ${str}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>年纪</td>
            <td>
                <input name="age" type="text" value="${employee.age}">
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input name="phone" type="text" value="${employee.phone}">
            </td>
        </tr>
        <tr>
            <td>参与项目</td>
            <td>
                <select name="train_id">
                    <c:forEach items="${requestScope.trains}" var="p">
                        <option value="${p.id}" ${p.id==employee.train_id?'selected':''}>
                                ${p.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                操作
            </td>
            <td>
                <input type="submit" value="更新员工">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
