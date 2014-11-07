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
  <%
     MovieBiz movieBiz=new MovieBizImpl();
  
     List<Type> types=movieBiz.getAllType();
		
		//绑定Type
		request.setAttribute("types", types);
		
   		
	
  
  
   %>

  
  
  
  <body>
     <a href="getTypes">添加电影</a>
      <a href="search.jsp">查找电影</a>
     <a href="index.jsp">首页</a>
     
     <h1>${requestScope.movies}</h1>
    
      
  <form action="searchMovie"  method="post">
		<table align="center">
			<tr>
				<td>
					电影名称
				</td>
				<td>
					<input type="input" name="name"  value="冰河世界4"/>
				</td>
			</tr>

			<tr>
				<td>
					电影类型
				</td>
				<td>
					<select name="typeid">
						<c:forEach items="${types}" var="type">
							<option value="${type.id}">
								${type.name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>


			<tr>
				<td>
					主演
				</td>
				<td>
					<input type="input" name="actor" value="猛犸象和树懒"/>
				</td>
			</tr>



			<tr>
				<td>
					导演
				</td>
				<td>
					<input type="input" name="director" value="梦工厂" />
				</td>
			</tr>


			<tr>
				<td>
					价格
				</td>
				<td>
					<input type="input" name="minPrice" value="35" />&nbsp;&nbsp;&nbsp;<input type="input" name="maxPrice" value="50" />
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="submit" value="提交" />
				</td>
			</tr>



		</table>

    </form>    
   
      
  
      
      
      
      
   
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
