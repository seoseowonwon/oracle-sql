<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.*" %>
<!-- controller  -->
<%
	// DAO호출로 model -> view 전달
	ArrayList<Dept> deptList = DeptDAO.selectDeptList();
	ArrayList<Emp> empList = EmpDAO.selectEmpList();
	ArrayList<HashMap<String, Object>> deptOnOffList = DeptDAO.deptOnOffList();
	ArrayList<HashMap<String, Object>> empAndDeptList = EmpDAO.empAndDeptList();
%>

<!-- View -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sql_001_voList</title>
</head>
<body>
	<h1>Dept List</h1>
	<table border="1">
		<tr>
			<th>deptNo</th>
			<th>dName</th>
			<th>loc</th>
		</tr>
		<%
			for(Dept d: deptList){
		%>
				<tr>
					<td><%=d.deptNo %></td>
					<td><%=d.dname %></td>
					<td><%=d.loc %></td>
				</tr>
		<%		
			}
		%>
	</table>
	
	<h1>Emp List</h1>
	<table border="1">
		<tr>
			<th>empNo</th>
			<th>ename</th>
			<th>sal</th>
		</tr>
		<%
			for(Emp e: empList){
		%>
				<tr>
					<td><%=e.empno %></td>
					<td><%=e.ename %></td>
					<td><%=e.sal %></td>
				</tr>
		<%		
			}
		%>
	</table>
	
	
	<h1>selectDeptOnOffList</h1>
	<table border="1">
		<tr>
			<th>deptNo</th>
			<th>dName</th>
			<th>loc</th>
			<th>onOff</th>
		</tr>
		<%
			// map단점 : IDE 자동 완성 기능을 사용할 수 없고, 형변환이 필요 할 수도 있다. 
			for(HashMap<String, Object> don: deptOnOffList){
		%>
				<tr>
					<td><%=(Integer)(don.get("deptNo")) %></td>
					<td><%=(String)(don.get("dname")) %></td>
					<td><%=(String)(don.get("loc")) %></td>
					<td><%=(String)(don.get("onOff")) %></td>
				</tr>
		<%		
			}
		%>
	</table>
	
	
	<h1>empAndDeptList</h1>
	<table border="1">
		<tr>
			<th>empNo</th>
			<th>ename</th>
			<th>deptNo</th>
			<th>dname</th>
		</tr>
		<%
			// map단점 : IDE 자동 완성 기능을 사용할 수 없고, 형변환이 필요 할 수도 있다. 
			for(HashMap<String, Object> ed: empAndDeptList){
		%>
				<tr>
					<td><%=(Integer)(ed.get("empNo")) %></td>
					<td><%=(String)(ed.get("ename")) %></td>
					<td><%=(Integer)(ed.get("deptNo")) %></td>
					<td><%=(String)(ed.get("dname")) %></td>
				</tr>
		<%		
			}
		%>
	</table>
</body>
</html>