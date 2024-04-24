<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%

	ArrayList<Emp> list = null;
	String[] ck = request.getParameterValues("ck");
	if(ck == null){ // null이 아닐때 체크값 수 출력
		System.out.println("where ck -->"+ck);
	} else {
		System.out.println("where ck -->"+ck.length);
		ArrayList <Integer> ckList = new ArrayList<>();
		for(String s : ck){ // ck라는 문자열을 숫자열로 변환
			ckList.add(Integer.parseInt(s));
		}
		list = EmpDAO.selectEmpListByGrade(ckList);
		System.out.println(list.size() + "결과셋 행(list.size)");
	}
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title></title>
</head>
<body>
   <h1>EMP GRADE 검색</h1>
   <form action="./q004WhereIn.jsp" method="post">
      GRADE : 
      <%
         for(int i=1; i<6; i=i+1) {
      %>
            <input name="ck" type="checkbox" value="<%=i%>"><%=i%>
      <%      
         }
      %>
      <br>
      <button type="submit">검색</button>
   </form>
   
   <hr>
   <h1>결과 View</h1>
   <%
   		if(ck == null){ // ck가 널이면 아무것도 출력 x
   			return;
   		}
   %>
   <table>
		<tr>
			<th>ename</th>
			<th>grade</th>
		</tr>
   		<%
   			for(Emp e : list){
   		%>
   				<tr>
   					<td><%= e.getEname() %></td>
   					<td><%= e.getGrade() %></td>
   				</tr>
   		<%		
   			}
   		
   		%>
   </table>
</body>
</html>