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

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
</head>
<body style="text-align: center">
<form action="${pageContext.request.contextPath}/UpdateTrainServlet" method="post" onsubmit="return makepre()"
      id="hehe">
    <input type="hidden" value="${train.id}" name="id">
    <table align="center" border="1" width="30%">
        <tr>
            <td>项目名称</td>
            <td>
                <input type="text" name="name" value="${train.name}">
            </td>
        </tr>
        <tr>
            <td>地点</td>
            <td>
                <input name="place" type="text" value="${train.place}">
            </td>
        </tr>
        <tr>
            <td>日期</td>
            <td>
                <input name="during" type="text" value="${train.during}">
            </td>
        </tr>

        <tr>
            <td>限制人数</td>
            <td>
                <input name="mlimit" type="text" value="${train.mlimit}">
            </td>
        </tr>
        <tr>
            <td>
            操作
            </td>
            <td>
                <input type="submit" value="更新项目">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
