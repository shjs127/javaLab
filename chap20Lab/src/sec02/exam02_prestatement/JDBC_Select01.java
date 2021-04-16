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
		
		// ---JDBC_Select �߰��� ���� -------
		ResultSet rs = null;
		ResultSet rs01 = null;
		int no = 0;
		String name, email, tel; // �����ͺ��̽����� ���� �ʵ尪 ������ ���� ����
		String sql; // SQL���� ������ ���� ����
		int cnt=0;	// ȸ���� ����
		
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
			System.out.println("��ȸ����:"+cnt);
			
			// ---JDBC_Select �߰��� ���� -------
			sql = "SELECT * FROM customer";
			System.out.printf("��ȣ \t �̸� \t\t �̸��� \t\t ��ȭ��ȣ \n");
			System.out
					.printf("-----------------------------------------------------------------\n");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ����� ���ڵ带 ������

			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
				System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email,
						tel);
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
		} finally {
			try {// rs, stmt, con ��ü�� close() �޼��带 ȣ���� ����
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
