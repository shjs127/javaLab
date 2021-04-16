package sec02.exam03_swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class InsertMember extends JFrame implements ActionListener {
	Connection con;
	PreparedStatement pstmt;
	Timestamp reg_date;

	private String names[] = { "���̵�", "��й�ȣ", "��й�ȣ ���Է�", "�̸�" };
	private JLabel labels[];
	private JTextField fields[];
	private JButton register, cancle, reWrite;
	private JPanel panelCenter, panelSouth;
	private int size = 4;

	public InsertMember() {
		super("ȸ�����");

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

		register = new JButton("ȸ�����");
		cancle = new JButton("����");
		reWrite = new JButton("�ٽ��ۼ�");

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
	}// ������ end

	// Database ���� �κ�
	public void dbConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹� �ε��� ����");
		}

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
			String userId = "SCOTT";
			String userPass = "TIGER";

			con = DriverManager.getConnection(url, userId, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ������ ����");
		}
	}

	// Event ó�� �κ�
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == register) { // ȸ�� ���
			dbConnect();
			insertMember();
			clearFields();
		} else if (ae.getSource() == cancle) { // ����
			System.exit(0);
		} else if (ae.getSource() == reWrite) { // �ٽ��ۼ�
			clearFields();
		}
	}

	// ȸ�� ���� ó�� �κ�
	public void insertMember() {
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String data[] = getFieldValues();

		// if(data[0].equals("") || data[1].equals("") || data[2].equals("") ||
		// data[3].equals("")){
		if (fields[0].getText().equals("") || fields[1].getText().equals("") || fields[2].getText().equals("")
				|| fields[3].getText().equals("")) {
			JOptionPane.showMessageDialog(this, "��� ������ �Է� �ϼ���!");
		} else if (fields[1].getText().equals(fields[2].getText())) {
			// }else if(data[1].equals(data[2])){ //��� ��ȣ�� ��ġ�ϸ� query�� ����

			String sql = "insert into mem02 values(?,?,?,?)";

			try {
				pstmt = con.prepareStatement(sql);
				// pstmt.setString(1,data[0]); //���̵�
				// pstmt.setString(2,data[1]); //��й�ȣ
				// pstmt.setString(3,data[3]); //�̸�

				pstmt.setString(1, fields[0].getText()); // ���̵�
				pstmt.setString(2, fields[1].getText()); // ��й�ȣ
				pstmt.setString(3, fields[3].getText()); // �̸�

				pstmt.setTimestamp(4, reg_date); // ȸ������ ��¥
				int result = pstmt.executeUpdate();

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "ȸ�� ���� �Ϸ�");
					// this.dispose();
					MemberManagement management = new MemberManagement();

				} else {
					JOptionPane.showMessageDialog(this, "ȸ�� ���� ����");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���ο� ���ڵ� �߰��� ����");
			}

		} else { // ��� ��ȣ�� ��ġ���� ������ �޽��� �ڽ�
			JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}

	// �ٽ� �ۼ� ó�� �κ�
	public void clearFields() {
		for (int i = 0; i < size; i++) {
			fields[i].setText("");
		}
	}

	// �Է��� ȸ�� �������� ���ϴ� �κ�
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