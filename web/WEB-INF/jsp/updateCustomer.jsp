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
<%
        String gender[] = {"男", "女"};
        String preference[] = {"读书", "看报", "唱歌", "大保健"};
        String type[] = {"普通客户", "会员用户", "VIP用户"};
        request.setAttribute("gender", gender);
        request.setAttribute("preference", preference);
        request.setAttribute("type", type);
%>
    </script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
</head>
<body style="text-align: center">
<form action="${pageContext.request.contextPath}/UpdateServlet" method="post" onsubmit="return makepre()"
      id="hehe">
    <input type="hidden" value="${customer.id}" name="id">
    <table align="center" border="1" id="table">
        <tr>
            <td>用户姓名</td>
            <td>
                <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td style="text-align: left">
                <c:forEach var="str" items="${gender}">
                    <input type="radio" name="gender" value="${str}" ${customer.gender == str?'checked':''}>
                    ${str}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input name="birthday" type="text" id="birthday" title="点击选择" onClick="showCalendar(this.id)"
                       value="${customer.birthday}">
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input name="cellphone" type="text" value="${customer.cellphone}">
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input name="email" type="text" value="${customer.email}">
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <c:forEach items="${preference}" var="p">
                    <input type="checkbox" name="pre"
                           value="${p}" ${fn:contains(customer.preference,p)?'checked':''}> ${p}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <c:forEach items="${type}" var="t">
                    <input type="radio" name="type" value="${t}" ${fn:contains(customer.type,t)?'checked':''}> ${t}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea name="description" rows="5" cols="65">${customer.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="修改信息">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
