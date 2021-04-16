package sec02.exam02_timestamp;
import java.io.BufferedReader;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

class  JDBC_Insert02{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";	

  Connection con = null;
  PreparedStatement pstmt =  null;

 // ResultSet  rs   = null;
  String sql;

   String name, email, tel, no, address;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );      

      //---JDBC_Insert �߰��� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println(" customer ���̺� �� �Է��ϱ� .....");
      System.out.print(" ��ȣ �Է�: ");
      no = br.readLine().trim();	  
      System.out.print(" �̸� �Է�: ");
      name = br.readLine().trim();            //���̺� �߰��� name �ʵ� ���� �Է� ����
      System.out.print(" �̸��� �Է�: ");
      email = br.readLine().trim();             //���̺� �߰��� email �ʵ� ���� �Է� ����
      System.out.print(" ��ȭ��ȣ �Է�: ");
      tel = br.readLine().trim();               //���̺� �߰��� tel �ʵ� ���� �Է� ����
      System.out.println("�ּҸ� �Է� �ϼ���?");
      address = br.readLine().trim();
	  int ino = Integer.parseInt(no);
      
	  Timestamp ts = new Timestamp(System.currentTimeMillis());
	  
      // INSERT �������� �ۼ�
	  sql = "INSERT into customer (no, name, email, tel, address, reg_date) values (?, ?, ?, ?,?,?)";

	  pstmt = con.prepareStatement( sql );
	  pstmt.setInt(1, ino);
	  pstmt.setString(2, name);
	  pstmt.setString(3, email);
	  pstmt.setString(4, tel);
	  pstmt.setString(5, address);
	  pstmt.setTimestamp(6, ts);
	  int result=pstmt.executeUpdate();   
	  	if(result == 1){
			 System.out.println(" Data insert success!! ");
	  	}else{
			System.out.println(" Data insert failed ");
		}
    } catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    } finally{
		try{
//			if( rs != null )   rs.close();        
			if( pstmt != null ) pstmt.close();
			if( con != null )  con.close();
		 } catch(Exception e){ 
			System.out.println( e.getMessage());
		}
    }
  }
} 
