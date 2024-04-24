package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import vo.Emp;

public class EmpDAO {
	// q005OrderBy.jsp
		public static ArrayList<Emp> selectEmpListSort(
				String col, String sort) throws Exception {
			
			// 매개값 디버깅
			System.out.println(col + " <--EmpDAO.selectEmpListSort param col");
			System.out.println(sort + " <--EmpDAO.selectEmpListSort param sort");
			
			ArrayList<Emp> list = new ArrayList<>();
			Connection conn = DBHelper.getConnection();
			
			String sql = "SELECT empno, ename"
					+ " FROM emp";
			
			if(col !=null && sort != null) {
				sql = sql + " ORDER BY "+col+" "+sort;
			}
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println(stmt);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				list.add(e);
			}
			
			conn.close();
			return list;	
		}
	
	
	
	
	//q004WhereIn.jsp
	public static ArrayList<Emp> selectEmpListByGrade(ArrayList<Integer> ckList)throws Exception{
		
		ArrayList<Emp> list = new ArrayList<>();
		/*
		 *	where grade in (?, ?) 
		 */
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT ename, grade"
				+ " FROM emp"
				+ " WHERE grade IN";
		PreparedStatement stmt = null;
		
		if(ckList.size() == 1) {
			sql = sql + "(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ckList.get(0));
		} else if (ckList.size() == 2) {
			sql = sql + "(?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ckList.get(0));
			stmt.setInt(2, ckList.get(1));
		} else if (ckList.size() == 3) {
			sql = sql + "(?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ckList.get(0));
			stmt.setInt(2, ckList.get(1));
			stmt.setInt(3, ckList.get(2));
		} else if (ckList.size() == 4) {
			sql = sql + "(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ckList.get(0));
			stmt.setInt(2, ckList.get(1));
			stmt.setInt(3, ckList.get(2));
			stmt.setInt(4, ckList.get(3));
		} else if (ckList.size() == 5) {
			sql = sql + "(?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ckList.get(0));
			stmt.setInt(2, ckList.get(1));
			stmt.setInt(3, ckList.get(2));
			stmt.setInt(4, ckList.get(3));
			stmt.setInt(5, ckList.get(4));
		}
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Emp e = new Emp();
			e.setEname(rs.getString("ename"));
			e.setGrade(rs.getInt("grade"));
			list.add(e);
		}
		
		conn.close();
		return list;
	}
	
	
	
	public static ArrayList<HashMap<String, String>> selectJobCaseList () throws Exception{
		String sql = "SELECT ename,"
				+ " job, CASE job"
				+ " WHEN 'PPERSIDENT' THEN '빨강'"
				+ " WHEN 'MANAGER' THEN '주황'"
				+ " WHEN 'ANALYST' THEN '노랑'"
				+ " WHEN 'CLERK' THEN '초록'"
				+ " ELSE '파랑' END color"
				+ " FROM emp"
				+ " ORDER BY"
				+ " (CASE"
				+ " WHEN color = '빨강' THEN 1"
				+ " WHEN color = '주황' THEN 2"
				+ " WHEN color = '노랑' THEN 3"
				+ " WHEN color = '초록' THEN 4"
				+ " ELSE 5 end) ASC";
		
		return null;
	}
	
	public static ArrayList<HashMap<String, Integer>> selectDeptNoCntList() throws Exception{
		
		
		return null;
		
	}
	
	// 중복을 제외한 DEPTNO 목록을 출력하는 메서드
	public static ArrayList<Integer> selectDeptNoList() throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT DISTINCT deptno deptNo"
				+ " FROM emp"
				+ " WHERE deptno IS NOT NULL"
				+ " ORDER BY deptno ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Integer i = rs.getInt("deptNo"); // 랩퍼타입과 기본타입간에 Auto Boxing
			list.add(i);
		}
		
		conn.close();
		return list;
	}
	
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
