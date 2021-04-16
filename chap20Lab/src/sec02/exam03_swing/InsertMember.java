package sec02.exam03_swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class InsertMember extends JFrame implements ActionListener {
	Connection con;
	PreparedStatement pstmt;
	Timestamp reg_date;

	private String names[] = { "아이디", "비밀번호", "비밀번호 재입력", "이름" };
	private JLabel labels[];
	private JTextField fields[];
	private JButton register, cancle, reWrite;
	private JPanel panelCenter, panelSouth;
	private int size = 4;

	public InsertMember() {
		super("회원등록");

		labels = new JLabel[size];
		fields = new JTextField[size];

		for (int i = 0; i < labels.length; i++)
			labels[i] = new JLabel(names[i]);

		for (int i = 0; i < fields.length; i++)
			fields[i] = new JTextField();

		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(size, 2));
		for (int i = 0; i < size; i++) {
			panelCenter.add(labels[i]);
			panelCenter.add(fields[i]);
		}

		register = new JButton("회원등록");
		cancle = new JButton("종료");
		reWrite = new JButton("다시작성");

		panelSouth = new JPanel();
		panelSouth.add(register);
		panelSouth.add(cancle);
		panelSouth.add(reWrite);

		add(panelCenter, "Center");
		add(panelSouth, "South");
		setBounds(300, 300, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		register.addActionListener(this);
		cancle.addActionListener(this);
		reWrite.addActionListener(this);
	}// 생성자 end

	// Database 연결 부분
	public void dbConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩에 실패");
		}

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
			String userId = "SCOTT";
			String userPass = "TIGER";

			con = DriverManager.getConnection(url, userId, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("커넥션 설정에 실패");
		}
	}

	// Event 처리 부분
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == register) { // 회원 등록
			dbConnect();
			insertMember();
			clearFields();
		} else if (ae.getSource() == cancle) { // 종료
			System.exit(0);
		} else if (ae.getSource() == reWrite) { // 다시작성
			clearFields();
		}
	}

	// 회원 가입 처리 부분
	public void insertMember() {
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String data[] = getFieldValues();

		// if(data[0].equals("") || data[1].equals("") || data[2].equals("") ||
		// data[3].equals("")){
		if (fields[0].getText().equals("") || fields[1].getText().equals("") || fields[2].getText().equals("")
				|| fields[3].getText().equals("")) {
			JOptionPane.showMessageDialog(this, "모든 정보를 입력 하세요!");
		} else if (fields[1].getText().equals(fields[2].getText())) {
			// }else if(data[1].equals(data[2])){ //비밀 번호가 일치하면 query문 실행

			String sql = "insert into mem02 values(?,?,?,?)";

			try {
				pstmt = con.prepareStatement(sql);
				// pstmt.setString(1,data[0]); //아이디
				// pstmt.setString(2,data[1]); //비밀번호
				// pstmt.setString(3,data[3]); //이름

				pstmt.setString(1, fields[0].getText()); // 아이디
				pstmt.setString(2, fields[1].getText()); // 비밀번호
				pstmt.setString(3, fields[3].getText()); // 이름

				pstmt.setTimestamp(4, reg_date); // 회원가입 날짜
				int result = pstmt.executeUpdate();

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "회원 가입 완료");
					// this.dispose();
					MemberManagement management = new MemberManagement();

				} else {
					JOptionPane.showMessageDialog(this, "회원 가입 실패");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("새로운 레코드 추가에 실패");
			}

		} else { // 비밀 번호가 일치하지 않으면 메시지 박스
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
		}
	}

	// 다시 작성 처리 부분
	public void clearFields() {
		for (int i = 0; i < size; i++) {
			fields[i].setText("");
		}
	}

	// 입력한 회원 정보값을 구하는 부분
	public String[] getFieldValues() {
		String values[] = new String[size];

		for (int i = 0; i < size; i++)
			values[i] = fields[i].getText();

		return values;
	}

	public static void main(String[] args) {
		InsertMember insert = new InsertMember();
	}
}