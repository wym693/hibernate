<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<form action="addMovie">
		<table align="center">
			<tr>
				<td>
					电影名称
				</td>
				<td>
					<input type="input" name="name" />
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
					<input type="input" name="actor" />
				</td>
			</tr>



			<tr>
				<td>
					导演
				</td>
				<td>
					<input type="input" name="director" />
				</td>
			</tr>


			<tr>
				<td>
					价格
				</td>
				<td>
					<input type="input" name="price" />
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="submit" value="提交" />
				</td>
			</tr>



		</table>

    </form>
	</body>
</html>
