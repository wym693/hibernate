<%@ page language="java" import="java.util.*,biz.*,bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="biz.impl.MovieBizImpl"%>
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
     <a href="getTypes">添加电影</a>
      <a href="search.jsp">查找电影</a>
      
      
     
     <%
        MovieBiz mb=new MovieBizImpl();
        
        List<Movie> movies=mb.getAllMovie();
        
       // out.print("movies的长度是"+movies.size());
        request.setAttribute("movies",movies);
     
      %>
      
   
  
      
      
      
      
   
   <h2>显示查询的结果</h2>   
      
    <c:if test="${not empty movies}">
    
    	<table align="center" border="1">
			<tr>
			    <td>
				    电影id
				</td>
				<td>
				    电影名称
				</td>
				<td>
				    电影类型
				</td>
				
				<td>
				    电影演员
				</td>
				
				<td>
				    电影导演
				</td>
				
				<td>
				    电影价格
				</td>
			</tr>
			
		
    
     <c:forEach items="${movies}" var="movie">
          <tr>
               <td>
                   ${movie.id}
               </td>
				<td>
				  ${movie.titile}
				</td>
				<td>
				     ${movie.type.name}
				</td>
				
				<td>
				    ${movie.actor}
				</td>
				
				<td>
				     ${movie.director}
				</td>
				
				<td>
				     ${movie.price}
				</td>
			</tr>
          
       
     </c:forEach>
     
     </table>
    
    </c:if> 
    <c:if test="${empty movies}">
       <h1>没有查询到数据</h1>
    
    </c:if> 
     
     
    
  </body>
</html>
