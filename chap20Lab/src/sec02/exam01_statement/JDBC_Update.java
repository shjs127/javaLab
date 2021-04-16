package sec02.exam01_statement;

import java.io.BufferedReader;  // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class  JDBC_Update{
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";

  Connection con = null;
  Statement stmt = null ;

  String sql;
  int no=0;
  String  name, email, tel ;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "SCOTT", "TIGER" );
      stmt= con.createStatement();

      //---JDBC_Insert 추가된 내용-------
      // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(" customer 테이블에 값 갱신하기 .....");
      System.out.print("수정할 회원번호를 입력 하세요?");
      no = Integer.parseInt(br.readLine());
      System.out.print("변경할 이름을 입력하세요: ");
      name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
      System.out.print("변경할 이메일 입력: ");
      email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
      System.out.print("변경할 전화번호 입력: ");
      tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음
      
      // INSERT 쿼리문을 작성
      sql  = "UPDATE customer SET email='" + email;
	  sql += "' , tel='" + tel + "', name='"+name+ "' WHERE no = "+ no;     
      
      //Statement 객체의 executeUpdate(sql) 메서드를 이용해 
      int result=stmt.executeUpdate(sql) ;  //데이터베이스 파일의 내용을 변경시킴
      if(result == 1){
    	  System.out.println("데이터 수정 성공");
      }else{
    	  System.out.println("데이터 수정 실패");
      }
     }
    catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
    }
    finally{
      try{
        if( stmt != null ) stmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
