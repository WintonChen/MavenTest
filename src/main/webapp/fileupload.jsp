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

	<s:form action="resultAction" namespace="/" method="POST"
		enctype="multipart/form-data">

		<s:file name="fileUpload" label="Select a File to upload" size="40" />

		<s:submit value="submit" name="submit" />

	</s:form>

</body>
</html>
