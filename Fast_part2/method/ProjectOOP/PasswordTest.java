package ProjectOOP;

public class PasswordTest {
	
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws PasswordException{
		
		if(password == null) {
			throw new PasswordException("null 안됨");
		} else if(password.length() < 5) {
			throw new PasswordException("비번 5이상하기");
		} else if(password.matches("[a-zA-Z]+")) {
			throw new PasswordException("특수문자 포함 필요");
		}
		
		this.password = password;
	}



	public static void main(String[] args) {
		
		PasswordTest test = new PasswordTest();
		String password = null;
		try {
			test.setPassword(password);
			System.out.println("오류없음1");
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}

		password = "abcd";
		try {
			test.setPassword(password);
			System.out.println("오류없음2");
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		
		password = "abcde";
		try {
			test.setPassword(password);
			System.out.println("오류없음3");
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		
		password = "abcde#1";
		try {
			test.setPassword(password);
			System.out.println("오류없음4");
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
