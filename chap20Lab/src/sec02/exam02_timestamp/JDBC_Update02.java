package sec02.exam02_timestamp;
import java.io.BufferedReader;  // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

class  JDBC_Update02{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  PreparedStatement pstmt =  null;

  String sql;
  int no;
  String name, email, tel, address ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );      

      //---JDBC_Insert �߰��� ����-------
      // ���̺� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer ���̺� �� �����ϱ� .....");
      System.out.println("��ȣ�� �Է� �ϼ���?");
      no = Integer.parseInt(br.readLine());
      System.out.print("������ �̸��� �Է��ϼ���: ");
      name = br.readLine();            //���̺� �߰��� name �ʵ� ���� �Է� ����
      System.out.print("������ �̸��� �Է�: ");
      email = br.readLine();             //���̺� �߰��� email �ʵ� ���� �Է� ����
      System.out.print("������ ��ȭ��ȣ �Է�: ");
      tel = br.readLine();               //���̺� �߰��� tel �ʵ� ���� �Է� ����     
      System.out.println("������ �ּҸ� �Է��ϼ���?");
      address = br.readLine();
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      
	  sql = "UPDATE customer SET name=?, email = ?, tel = ?, address=?, reg_date=? where no = ?";
	  pstmt = con.prepareStatement( sql );
	  pstmt.setString(1, name);
	  pstmt.setString(2, email);
	  pstmt.setString(3, tel);
	  pstmt.setString(4, address);
	  pstmt.setTimestamp(5, ts);
	  pstmt.setInt(6, no);
      int result=pstmt.executeUpdate() ;  
      	if(result == 1){
 		 System.out.println(" ������ ���� ����!! ");
       }else{
 		 System.out.println(" ������ ���� ���� ");
 	  }
	}
    catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    }
    finally{
      try{
        if( pstmt != null ) pstmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
