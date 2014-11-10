<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
    <form action="upload" method="POST" enctype="multipart/form-data">
      <label>用户名</label>
      <input type="text" name="username"  value="zhangsan"/><br/>
      
      <label>请上传用户的头像</label>
      <input type="file" name="photo"  /><br/>
      
      <input type="submit" value="确认上传"/>
       
    
    
    </form>
  
  
  
  
  
  
  
  
  
  </body>
</html>
