package connection;

public class User {
	private Integer id;
	private String userName;
	private String passWord;
	public User(){
	}

	public User(Integer userId, String UserName, String PassWord) {
		super();
		id = userId;
		userName = UserName;
		passWord = PassWord;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
