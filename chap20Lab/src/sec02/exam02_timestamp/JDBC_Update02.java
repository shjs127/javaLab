package sec02.exam02_timestamp;
import java.io.BufferedReader;  // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
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

      //---JDBC_Insert 추가된 내용-------
      // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer 테이블에 값 갱신하기 .....");
      System.out.println("번호를 입력 하세요?");
      no = Integer.parseInt(br.readLine());
      System.out.print("변경할 이름을 입력하세요: ");
      name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
      System.out.print("변경할 이메일 입력: ");
      email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
      System.out.print("변경할 전화번호 입력: ");
      tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음     
      System.out.println("변경할 주소를 입력하세요?");
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
 		 System.out.println(" 데이터 수정 성공!! ");
       }else{
 		 System.out.println(" 데이터 수정 실패 ");
 	  }
	}
    catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
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
