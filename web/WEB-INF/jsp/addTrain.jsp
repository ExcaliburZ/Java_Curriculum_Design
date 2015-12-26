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
<form action="${pageContext.request.contextPath}/AddTrainServlet" method="post" onsubmit="return makepre()" id="form">
    <table align="center" border="1" width="30%" >
        <tr>
            <td>项目名称</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>地点</td>
            <td>
                <input name="place" type="text">
            </td>
        </tr>
        <tr>
            <td>日期</td>
            <td>
                <input name="during" type="text">
            </td>
        </tr>

        <tr>
            <td>限制人数</td>
            <td>
                <input name="mlimit" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="添加项目">
            </td>
        </tr>

    </table>
</form>
</body>
</html>

