<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="dao.*" %>
<%@ page import="java.util.*" %>
   
   
<%
	//controller
	ArrayList<HashMap<String, Object>> list
		= EmpDAO.selectSelf();
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>SELF</h1>
	<table border = "1">
		<tr>
			<th>grade</th>
			<th>empNo</th>
			<th>eName</th>
			<th>mgrGrade</th>
			<th>mgrName</th>
		</tr>
		
		<%
			for(HashMap<String, Object> m : list){
		%>
			<tr>
				<td>
					<%
						for(int i = 0; i < (Integer)(m.get("grade")) ; i ++){
					%>
							&#128151;
					<%	
						}
					%>
				</td>
				<td><%=m.get("empNo")%></td>
				<td><%=m.get("eName")%></td>
				<td>
					<%
						for(int i = 0; i < (Integer)(m.get("mgrGrade")) ; i ++){
					%>
							&#127880;
					<%	
						}
					%>
				</td>
				<td><%=m.get("mgrName")%></td>
			</tr>
		<%		
			}
		%>
	</table>	
	
</body>
</html>