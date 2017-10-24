<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>show tables</title>
</head>
<body>

<table border="1px" cellspacing="0" width=800px>
	<tr>
		<td>编号</td>
		<td>用户名</td>
		<td>密码</td>
		<td>删除</td>
		<td>修改</td>
		<td>添加</td>
		
	</tr>
	
	<c:forEach items="${list }" var="l"> 
		<tr>
			<td>${l.id }</td>
				<td>${l.username }</td>
				<td>${l.password }</td>
				<td><a href="./delete?id=${l.id }" onclick="return confirm('确认删除?')">删除</a></td>
				<td><a href=update.jsp>修改</a></td>
				<td><a href=add.jsp>新增</a></td>
				
		</tr>
		</c:forEach>
	<tr>
		<form action="./add" method="get">
		
		<td><input type="text" name="username" placeholder="user"/></td>
		<br/>
		<td><input type="password" name="password" placeholder="pwd"/></td>
		<br/>
		<td><input type="submit" value="Add"/></td>
			</tr>
	
		</form>
	
	
</table>


</body>
</html>