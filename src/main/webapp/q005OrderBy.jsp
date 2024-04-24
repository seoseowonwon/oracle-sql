<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "dao.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "java.util.*" %>

<!-- Controller -->
<% 
	//� �÷����� ����
	String col = request.getParameter("col");
	System.out.println("q005 param col -->" + col);

	// asc / desc
	String sort = request.getParameter("sort");
	System.out.println("q005 param ename -->" + sort);
	
	// DAO ȣ�� -> �� �� �ޱ�
	ArrayList<Emp> list = EmpDAO.selectEmpListSort(col, sort);
	System.out.println(list.size()+ "<--q005OrderBy.jsp list.size()");
%>     
    
<!-- View -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>empno
				<a href="./q005OrderBy.jsp?col=empno&sort=asc">����</a>
				<a href="./q005OrderBy.jsp?col=empno&sort=desc">����</a>
			</th>
			<th>ename
				<a href="./q005OrderBy.jsp?col=ename&sort=asc">����</a>
				<a href="./q005OrderBy.jsp?col=ename&sort=desc">����</a>
			</th>
		</tr>
		
		<%
			for(Emp e : list){
		%>
				<tr>
					<td><%=e.getEmpno() %></td>
					<td><%=e.getEname() %></td>
				</tr>
		<%		
			}
			
		%>
	</table>
</body>
</html>