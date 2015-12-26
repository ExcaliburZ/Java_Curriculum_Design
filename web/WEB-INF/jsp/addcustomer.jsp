<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function makepre(){
            var pres = document.getElementsByName("pre");
            var preference = "";
            for(var i=0;i<pres.length;i++){
                var input = pres[i];
                if(input.checked==true){
                    preference = preference + input.value + ",";
                }
            }
            preference = preference.substr(0,preference.length-1);
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
        table{
            font-size: 24px;
            margin-top: 80px;
            font-family: "黑体";
        }
        input{
            font-size: 24px;
            font-family: "黑体";
        }
    </style>
</head>
<body style="text-align: center">
<form action="${pageContext.request.contextPath}/addCustomerServlet" method="post" onsubmit="return makepre()" id="form">
    <table align="center" border="1" width="30%" >
        <tr>
            <td>用户姓名</td>
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
            <td>生日</td>
            <td>
                <input name="birthday" type="text" id="birthday" title="点击选择" onClick="showCalendar(this.id)">
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input name="cellphone" type="text">
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input name="email" type="text">
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <c:forEach items="${preference}" var="p">
                    <input type="checkbox" name="pre" value="${p}"> ${p}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <c:forEach items="${type}" var="t">
                    <input type="radio" name="type" value="${t}"> ${t}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea name="description" rows="5" cols="65"></textarea>
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

