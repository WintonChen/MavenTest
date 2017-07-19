<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'fileupload.jsp' starting page</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head />
</head>

<body>
	<h1>Struts 2 file upload example</h1>

	<form action="resultAction"  method="POST"
		enctype="multipart/form-data">

      <label for="fileUpload">Upload your file</label>
      <input type="file" name="fileUpload" />
      <input type="submit" value="Upload"/>

	</form>

</body>
</html>
