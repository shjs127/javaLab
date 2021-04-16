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
	
   private String names[] = { "���̵�", "��й�ȣ", "�̸�", "������" };
   private JLabel labels[], label1;
   private JTextField fields[], searchId;
   private JButton update, delete, search;
   private JPanel panelNorth, panelCenter, panelSouth;
   private int size = 4;
   
   public MemberManagement(){
	  super("ȸ������ - ȸ������ �˻�, ����, Ż��");
	  
	  dbConnect();	  
	  
	  panelNorth = new JPanel();
	  label1 = new JLabel(names[0]);
	  searchId= new JTextField(10);
	  search = new JButton("�˻�");	  
	  
	  panelNorth.add(label1);
	  panelNorth.add(searchId);
	  panelNorth.add(search);
	  
      labels = new JLabel[ size ];
      fields = new JTextField[ size ];

	  // JLabel ��ü ����
      for ( int i = 0; i < labels.length; i++ ){
         labels[ i ] = new JLabel( names[ i ] );
      }  

	  // JTextField ��ü ����
      for ( int i = 0; i < fields.length; i++ ){
         fields[ i ] = new JTextField();
      }

      panelCenter = new JPanel();
      panelCenter.setLayout( new GridLayout( size, 2 ) );
      for ( int i = 0; i < size; i++ ) {
         panelCenter.add( labels[ i ] );
         panelCenter.add( fields[ i ] );
      }      
	  
      update = new JButton("��������");      
      delete = new JButton("ȸ��Ż��");           
      
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

   }// ������ end  
   

   //Database ���� �κ�
   public void dbConnect(){ 
	    try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("����̹� �ε��� ����");
		}

		try{
			String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
	        String userId = "SCOTT"; 
	        String userPass = "TIGER"; 	        
	  	    
	        con =DriverManager.getConnection(url,userId,userPass);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ������ ����");
		}
   }

   // Event ó�� �κ�
   public void actionPerformed(ActionEvent ae){

		if(ae.getSource() == search){ //�˻�
			searchMember();	
		}else if(ae.getSource() == update){ //��������
			updateMember();
    	    clearFields();
		}else if(ae.getSource() == delete){ // ȸ��Ż��(����)
			deleteMember();
            clearFields();
		}
   }
   
   //�˻� ó�� �κ�
   public void searchMember(){
	   String data[]= new String[4];	   
	   String id = searchId.getText().trim();
	   
	 if(id.equals("")){  // ���̵� �Է����� �ʾ����� 
		  JOptionPane.showMessageDialog(this, "ID�� �Է� �ϼ���");
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
        	  fields[0].setText(data[0]);     // ���̵�
        	  fields[0].setEnabled(false);
        	  fields[1].setText("");          // ��й�ȣ
        	  fields[2].setText(data[2]);     // �̸�
        	  fields[3].setText(data[3]);     // ������
        	  fields[3].setEnabled(false);
        	  
        	  searchId.setText("");    	  
        	  
          }else{
        	  JOptionPane.showMessageDialog(this, "�׷� ���̵� �����ϴ�.");
        	  searchId.setText("");
        	  return;
          }
          
 //          setFieldValues(data);
 //          searchId.setText("");
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("���ڵ� �˻� ����");
	   }      
       
	  }// if~else end 
   }
   
   //���� ó�� �κ�
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
				JOptionPane.showMessageDialog(this, "ȸ������ ���� ����.");
			 }else{
				JOptionPane.showMessageDialog(this, "ȸ������ ���� ����.");
			 }
    	   }else{
    		   JOptionPane.showMessageDialog(this, "��й�ȣ�� ���� �ʽ��ϴ�.");
    		   return;
    	   } 
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("���ڵ� ���� ����");
		}
   }
   
   //���� ó�� �κ�
   public void deleteMember(){
	   data = getFieldValues();
	   String sql = "delete from mem02 where id=? ";       
       
	   try{
    	   if( passwdCompare()){
		     pstmt = con.prepareStatement(sql);
             pstmt.setString(1,data[0]);
		     int res = pstmt.executeUpdate();
			 if(res == 1){
				JOptionPane.showMessageDialog(this, "ȸ��Ż�� ����.");
			 }else{
				JOptionPane.showMessageDialog(this, "ȸ��Ż�� ����.");
			 }
    	   }else{
    		   JOptionPane.showMessageDialog(this, "��й�ȣ�� ���� �ʽ��ϴ�.");
    		   return;
    	   } 
       }catch(SQLException e){
			e.printStackTrace();
			System.out.println("���ڵ� ��������");
		}
   }
   
   //��� ��ȣ �� �κ�
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
			System.out.println("��й�ȣ �񱳽���");
		}
       
       return test;
   }   
  

    // �ٽ� �ۼ� ó�� �κ�
   public void clearFields(){
      for ( int i = 0; i < size; i++ )
         fields[ i ].setText("");
   }
   
   // �Է��� ȸ�� �������� ���ϴ� �κ�
   public String[] getFieldValues(){ 
	      String values[] = new String[ size ];

	      for ( int i = 0; i < size; i++ ) 
	         values[ i ] = fields[ i ].getText();

	      return values;
   }

   // ȸ���� �������� ���� �ϴ� �κ�(������)
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