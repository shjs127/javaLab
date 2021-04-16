package sec02.exam02_prestatement;
import java.sql.*;
import java.io.*;  // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 

class  JDBC_Delete01{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  PreparedStatement pstmt =  null;
  String sql;
  String name, email, tel ;
  int ino;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );      

      //---JDBC_Delete 변경된 내용-------
      // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
      System.out.print("삭제할 회원의 회원번호를 입력하세요? ");
      ino = Integer.parseInt(br.readLine());     //테이블에서 삭제할 name 필드 값을 입력 받음
   
      // DELETE 쿼리문을 작성
	  sql = "DELETE FROM customer WHERE no = ?";
	  pstmt = con.prepareStatement( sql );
	  pstmt.setInt(1, ino);	  
      int result=pstmt.executeUpdate() ;   
	  if(result==1){
		  System.out.println("회원 삭제 성공");
	  }else{
		  System.out.println("회원 삭제 실패");
	  }
      
	}catch(Exception e){
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
