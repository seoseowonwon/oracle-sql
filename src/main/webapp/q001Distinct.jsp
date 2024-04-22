<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>
<!-- Model -->
<%
	ArrayList<Integer> list = EmpDAO.selectDeptNoList();
%>

<!-- View -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<select name="deptNo">
		<option value="">:::선택:::</option>
		<%
			for(Integer i: list) {
		%>
				<option value="<%=i%>"><%=i%></option>
		<%	
			}
		%>
	</select>
</body>
</html>
