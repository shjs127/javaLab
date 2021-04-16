package sec02.exam02_prestatement;
import java.io.BufferedReader; // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class JDBC_Insert01 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

		Connection con = null;
		PreparedStatement pstmt = null;

		//ResultSet rs = null;
		String sql;

		String name, email, tel, no;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "TIGER");

			// ---JDBC_Insert �߰��� ����-------
			// ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println(" customer ���̺� �� �Է��ϱ� .....");
			System.out.print(" ��ȣ �Է�: ");
			no = br.readLine();
			System.out.print(" �̸� �Է�: ");
			name = br.readLine(); // ���̺� �߰��� name �ʵ� ���� �Է� ����
			System.out.print(" �̸��� �Է�: ");
			email = br.readLine(); // ���̺� �߰��� email �ʵ� ���� �Է� ����
			System.out.print(" ��ȭ��ȣ �Է�: ");
			tel = br.readLine(); // ���̺� �߰��� tel �ʵ� ���� �Է� ����

			int ino = Integer.parseInt(no);

			// INSERT �������� �ۼ�
			sql = "INSERT into customer (no, name, email, tel) values (?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ino);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
			int result=pstmt.executeUpdate();
			if(result == 1){
				System.out.println("������ �Է� ����");
			}else{
				System.out.println("������ �Է� ����");
			}

		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
		} finally {
			try {
		//		if (rs != null)
		//			rs.close();
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
