package sec02.exam03_swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MemberManagement extends JFrame implements ActionListener {

   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;
   Timestamp reg_date ;
   String data[];
	
   private String names[] = { "아이디", "비밀번호", "이름", "가입일" };
   private JLabel labels[], label1;
   private JTextField fields[], searchId;
   private JButton update, delete, search;
   private JPanel panelNorth, panelCenter, panelSouth;
   private int size = 4;
   
   public MemberManagement(){
	  super("회원관리 - 회원정보 검색, 수정, 탈퇴");
	  
	  dbConnect();	  
	  
	  panelNorth = new JPanel();
	  label1 = new JLabel(names[0]);
	  searchId= new JTextField(10);
	  search = new JButton("검색");	  
	  
	  panelNorth.add(label1);
	  panelNorth.add(searchId);
	  panelNorth.add(search);
	  
      labels = new JLabel[ size ];
      fields = new JTextField[ size ];

	  // JLabel 객체 생성
      for ( int i = 0; i < labels.length; i++ ){
         labels[ i ] = new JLabel( names[ i ] );
      }  

	  // JTextField 객체 생성
      for ( int i = 0; i < fields.length; i++ ){
         fields[ i ] = new JTextField();
      }

      panelCenter = new JPanel();
      panelCenter.setLayout( new GridLayout( size, 2 ) );
      for ( int i = 0; i < size; i++ ) {
         panelCenter.add( labels[ i ] );
         panelCenter.add( fields[ i ] );
      }      
	  
      update = new JButton("정보수정");      
      delete = new JButton("회원탈퇴");           
      
      panelSouth = new JPanel();      
      panelSouth.add( update );
      panelSouth.add( delete );     
      
      add( panelNorth, "North" );
      add( panelCenter, "Center" );
      add( panelSouth, "South" );     
	  setBounds(300,300,350,300);
      setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  search.addActionListener(this);
	  update.addActionListener(this);	  
      delete.addActionListener(this);	  

   }// 생성자 end  
   

   //Database 연결 부분
   public void dbConnect(){ 
	    try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩에 실패");
		}

		try{
			String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
	        String userId = "SCOTT"; 
	        String userPass = "TIGER"; 	        
	  	    
	        con =DriverManager.getConnection(url,userId,userPass);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("커넥션 설정에 실패");
		}
   }

   // Event 처리 부분
   public void actionPerformed(ActionEvent ae){

		if(ae.getSource() == search){ //검색
			searchMember();	
		}else if(ae.getSource() == update){ //정보수정
			updateMember();
    	    clearFields();
		}else if(ae.getSource() == delete){ // 회원탈퇴(삭제)
			deleteMember();
            clearFields();
		}
   }
   
   //검색 처리 부분
   public void searchMember(){
	   String data[]= new String[4];	   
	   String id = searchId.getText().trim();
	   
	 if(id.equals("")){  // 아이디를 입력하지 않았을때 
		  JOptionPane.showMessageDialog(this, "ID를 입력 하세요");
		  searchId.requestFocus();
	 }else{	   
	   
	   String sql = "select * from mem02 where id = ?";
  
       try{
		  pstmt = con.prepareStatement(sql);
		  pstmt.setString(1,id);
          rs = pstmt.executeQuery();
		  
          if(rs.next()){
        	  data[0] = rs.getString("id");
        	  data[1] = rs.getString("passwd");
        	  data[2] = rs.getString("name");
        	  data[3] = rs.getTimestamp("reg_date").toString();	       	 
        	  
 //       	  setFieldValues(data);
        	  fields[0].setText(data[0]);     // 아이디
        	  fields[0].setEnabled(false);
        	  fields[1].setText("");          // 비밀번호
        	  fields[2].setText(data[2]);     // 이름
        	  fields[3].setText(data[3]);     // 가입일
        	  fields[3].setEnabled(false);
        	  
        	  searchId.setText("");    	  
        	  
          }else{
        	  JOptionPane.showMessageDialog(this, "그런 아이디가 없습니다.");
        	  searchId.setText("");
        	  return;
          }
          
 //          setFieldValues(data);
 //          searchId.setText("");
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("레코드 검색 실패");
	   }      
       
	  }// if~else end 
   }
   
   //수정 처리 부분
   public void updateMember(){
	   data = getFieldValues();
	   String sql = "update mem02 set name=? where id=? ";
//	   Timestamp reg_date = new Timestamp(System.currentTimeMillis());
       
	   try{
    	   if( passwdCompare()){
		     pstmt = con.prepareStatement(sql);
             pstmt.setString(1,data[2]);
             pstmt.setString(2,data[0]);
		     int res = pstmt.executeUpdate();
			 if(res == 1){
				JOptionPane.showMessageDialog(this, "회원정보 수정 성공.");
			 }else{
				JOptionPane.showMessageDialog(this, "회원정보 수정 실패.");
			 }
    	   }else{
    		   JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
    		   return;
    	   } 
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("레코드 수정 실패");
		}
   }
   
   //삭제 처리 부분
   public void deleteMember(){
	   data = getFieldValues();
	   String sql = "delete from mem02 where id=? ";       
       
	   try{
    	   if( passwdCompare()){
		     pstmt = con.prepareStatement(sql);
             pstmt.setString(1,data[0]);
		     int res = pstmt.executeUpdate();
			 if(res == 1){
				JOptionPane.showMessageDialog(this, "회원탈퇴 성공.");
			 }else{
				JOptionPane.showMessageDialog(this, "회원탈퇴 실패.");
			 }
    	   }else{
    		   JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
    		   return;
    	   } 
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("레코드 삭제실패");
		}
   }
   
   //비밀 번호 비교 부분
   public boolean passwdCompare(){
       boolean test = false;  
	   String sql = "select passwd from mem02 where id= ?";       
       
       try{
		  pstmt = con.prepareStatement(sql);
          pstmt.setString(1,data[0]);
          rs = pstmt.executeQuery();
          
		  if(rs.next()){
             if(rs.getString("passwd").equals(data[1]))
        	    test = true;
             else
        	     test = false;
		  }
		  
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("비밀번호 비교실패");
		}
       
       return test;
   }   
  

    // 다시 작성 처리 부분
   public void clearFields(){
      for ( int i = 0; i < size; i++ )
         fields[ i ].setText("");
   }
   
   // 입력한 회원 정보값을 구하는 부분
   public String[] getFieldValues(){ 
	      String values[] = new String[ size ];

	      for ( int i = 0; i < size; i++ ) 
	         values[ i ] = fields[ i ].getText();

	      return values;
   }

   // 회원의 정보값을 설정 하는 부분(수정시)
   public void setFieldValues( String s[] ){
	      for ( int i = 0; i < size; i++ )
	      fields[ i ].setText( s[ i ] );
	      
	      fields[0].setEnabled(false);
	      fields[1].setText("");
	      fields[3].setEnabled(false);
   }
   
   public static void main(String[] args){
	   MemberManagement management= new MemberManagement();
   }
}