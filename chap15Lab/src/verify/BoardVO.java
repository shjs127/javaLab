package verify;
// VO(Value Object) 클래스

// DTO(Data Transfer Object) 클래스

public class BoardVO extends Object {

	// 멤버변수
	private String register;
	private String subject;
	private String email;
	private String content;
	private String passwd;

	// 생성자
	public BoardVO(String register, String subject, String email, String content, String passwd) {
		super();
		this.register = register;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.passwd = passwd;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "작성자:" + register + ",이메일:" + email + ",제목:" + subject + ",글내용:" + content;
	}

}
