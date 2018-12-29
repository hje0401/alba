package stockmgmt.login.model;

public class LoginVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userAuth;
	private String userPosition;
	private String saveIdYn;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getSaveIdYn() {
		return saveIdYn;
	}
	public void setSaveIdYn(String saveIdYn) {
		this.saveIdYn = saveIdYn;
	}
	
}
