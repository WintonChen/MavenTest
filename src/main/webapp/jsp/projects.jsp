<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单处理</title>
</head>

<style>
.error {
   color: #ff0000;
}

.errorblock {
   color: #000;
   background-color: #ffEEEE;
   border: 3px solid #ff0000;
   padding: 8px;
   margin: 16px;
}
</style>

<body>
	<h2>Project Information</h2>
	<form:form action="/MavenTest/addProjects" method="post" commandName="projects">
	    <form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="appid">appid：</form:label></td>
				<td><form:input path="appid" /></td>
				<td><form:errors path="appid" cssClass="error"/></td>
			<tr>
			<tr>
				<td><form:label path="name">产品名称：</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"/></td>
			<tr>
			<tr>
				<td><form:label path="icon">产品图标：</form:label></td>
				<td><form:input path="icon" /></td>
			<tr>
			<tr>
				<td><form:label path="platform">平台：</form:label></td>
				<td><form:input path="platform" /></td>
			<tr>
			<tr>
				<td><form:label path="type">类型：</form:label></td>
				<td><form:input path="type" /></td>
			<tr>
			<tr>
				<td><form:label path="info">产品描述：</form:label></td>
				<td><form:input path="info" /></td>
			<tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
