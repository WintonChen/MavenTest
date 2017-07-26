<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>提交的产品信息如下 - </h2>
   <table>
    <tr>
        <td>appid：</td>
        <td>${appid}</td>
    </tr>
    <tr>
        <td>产品名称：</td>
        <td>${name}</td>
    </tr>
   </table>  
</body>
</html>
