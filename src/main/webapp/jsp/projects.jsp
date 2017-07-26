<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单处理</title>
</head>
<body>
	<h2>Project Information</h2>
	<form:form action="/MavenTest/addProjects" method="post">
		<table>
			<tr>
				<td><form:label path="appid">appid：</form:label></td>
				<td><form:input path="appid" /></td>
			<tr>
			<tr>
				<td><form:label path="name">产品名称：</form:label></td>
				<td><form:input path="name" /></td>
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
