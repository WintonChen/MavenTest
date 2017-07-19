<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
  </head>
  <body>
    <h1>struts 2 file upload example</h1>
    <p><a href="<s:url action='hello'/>">Hello World</a></p>
    
    <s:form action="upload" namespace="/" method="post"
     enctype="multipart/form-data">
    	<s:file name="fileUpload" label="Select a File to upload" size="40" />

		<s:submit value="submit" name="submit" />
    </s:form>
    
  </body>
</html>