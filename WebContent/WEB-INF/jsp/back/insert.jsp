<%@ page language="Java" pageEncoding="utf-8"  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
	<title>新增内容页</title>	
</head>
<body>
	<form action="Insert">
		序号：</br>
		<input type="text" name="id" />
		</br>
		命令名称：</br>
		<input type="text" name="command" />
		</br>
		命令描述：</br>
		<input type="text" name="description" />
		</br>
		命令内容：</br>
		<input type="text" name="content" />
		</br>
		<input type="submit"  value="提交" onclick="window.location.href='Insert'"/>
	</form>
</body>
</html>