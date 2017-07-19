<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'result.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>Struts 2 file upload example</h1>

	<div>
		<div class="ads-in-post hide_if_width_less_800">
			<script async
				src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
			<!-- 728x90 - After2ndH4 -->
			<ins class="adsbygoogle hide_if_width_less_800"
				style="display:inline-block;width:728px;height:90px"
				data-ad-client="ca-pub-2836379775501347" data-ad-slot="3642936086"
				data-ad-region="yiibairegion"></ins>
			<script>
				(adsbygoogle = window.adsbygoogle || []).push({});
			</script>
		</div>
	</div>
	<h2>
		File Name :
		<s:property value="fileUploadFileName" />
	</h2>

	<h2>
		Content Type :
		<s:property value="fileUploadContentType" />
	</h2>

	<h2>
		File :
		<s:property value="fileUpload" />
	</h2>
</body>
</html>
