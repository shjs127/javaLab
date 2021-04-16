package sec02.exam02_prestatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class JDBC_Select01 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		// ---JDBC_Select 추가된 내용 -------
		ResultSet rs = null;
		ResultSet rs01 = null;
		int no = 0;
		String name, email, tel; // 데이터베이스에서 얻어온 필드값 저장할 변수 선언
		String sql; // SQL문을 저장할 변수 선언
		int cnt=0;	// 회원수 저장
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "TIGER");

			String sql01="select count(*) from customer";
			pstmt = con.prepareStatement(sql01);
			rs01 = pstmt.executeQuery();
			if(rs01.next()){
				cnt = rs01.getInt(1);
		//		cnt = rs01.getInt("count(*)");
			}
			System.out.println("총회원수:"+cnt);
			
			// ---JDBC_Select 추가된 내용 -------
			sql = "SELECT * FROM customer";
			System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
			System.out
					.printf("-----------------------------------------------------------------\n");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 얻어진 레코드를 가져옴

			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
				System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email,
						tel);
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
			try {// rs, stmt, con 객체를 close() 메서드를 호출해 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
