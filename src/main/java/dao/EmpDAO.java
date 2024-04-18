package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import vo.Emp;

public class EmpDAO {
	// join으로 Map을 사용하는 경우
	public static ArrayList<HashMap<String, Object>> empAndDeptList() throws Exception{
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " emp.empno empNo, emp.ename ename, emp.deptno deptNo,"
				+ " dept.dname dname"
				+ " FROM emp INNER JOIN dept"
				+ " On emp.deptno = dept.deptno";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("empNo", rs.getInt("empNo"));
			m.put("ename", rs.getString("ename"));
			m.put("deptNo", rs.getInt("deptNo"));
			m.put("dname", rs.getString("dname"));
			
			
			list.add(m);
		}
		
		
		
		return list;
	}
	
	//VO 사용
	public static ArrayList<Emp> selectEmpList() throws Exception{
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " empno empNo, ename, sal"
				+ " FROM emp";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			Emp e = new Emp();
			e.empno = rs.getInt("empNo");
			e.ename = rs.getString("ename");
			e.sal = rs.getDouble("sal");
			list.add(e);
		}
			
		return list;
	}
}
