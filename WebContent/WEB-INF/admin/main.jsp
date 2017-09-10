<%@page import="xmx.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	Object o = session.getAttribute("admin");
	Admin admin = null;
	if (o != null && o instanceof Admin) {
		admin = (Admin) o;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<script src="<%=basePath%>jquery/jquery-2.2.4.min.js"
	type="text/javascript"></script>
<title>后台主页</title>
<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<div>后台主页</div>
	
	<div>欢迎<%=admin.getName()%></div>
</body>
</html>