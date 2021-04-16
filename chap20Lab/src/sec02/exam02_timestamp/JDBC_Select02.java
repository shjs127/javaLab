package sec02.exam02_timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class  JDBC_Select02{
  public static void main(String[] args)  {

	String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

    Connection con  = null;
    PreparedStatement pstmt =  null;
    //---JDBC_Select �߰��� ���� -------
    ResultSet  rs   = null;
	int no = 0; 
    String name="", email="", tel="", address="", ts="";  //�����ͺ��̽����� ���� �ʵ尪 ������ ���� ����
    String sql;               //SQL���� ������ ���� ����

    try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );
     
      //---JDBC_Select �߰��� ���� -------
      sql = "SELECT * FROM customer";
      System.out.printf("��ȣ \t �̸� \t\t �̸��� \t\t ��ȭ��ȣ \t �ּ�\t ��¥\n");
      System.out.printf("-----------------------------------------------------------------\n");
	  pstmt = con.prepareStatement( sql );
      rs = pstmt.executeQuery();  //����� ���ڵ带 ������

      while( rs.next() ){
		 no = rs.getInt("no"); 
         name = rs.getString("name");  
         email = rs.getString("email");     
         tel   = rs.getString("tel"); 
         address = rs.getString("address");
         ts = rs.getTimestamp("reg_date").toString();
        System.out.printf(" %d \t %s \t %s \t %s\t %s\t %s\t  \n", no, name,email,tel,address,ts);
      } 
    }
    catch(Exception e){
      System.out.println("�����ͺ��̽� ���� ����!");
    }
    finally{
      try{//rs, stmt, con ��ü�� close() �޼��带 ȣ���� ����
        if( rs != null )      rs.close();        
        if( pstmt != null )    pstmt.close();
        if( con != null )     con.close();
      }
      catch(Exception e){
        System.out.println( e.getMessage( ));  
      }
    }
  }
}  

