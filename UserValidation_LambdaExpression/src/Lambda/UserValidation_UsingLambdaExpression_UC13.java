package Lambda;

import java.util.regex.Pattern;

@FunctionalInterface
interface ValidateUser {
	boolean validateUser(String input);
}

public class UserValidation_UsingLambdaExpression_UC13 {

	public static final String firstName = "[A-Z]{1}[A-za-z]{2,}";
	public static final String lastName = "[A-Z]{1}[A-za-z]{2,}";
	public static final String emailAddress = "^([0-9a-zA-Z]{1,})([+-._][a-z0-9A-Z]{1,})*@([0-9a-zA-Z]{1,})(.[a-zA-Z]{2,4})?.([a-zA-Z]{2,3})$";
	public static final String mobileNo = "[0-9]{2}[; ;][0-9]{10}";
	public static final String password = "^(?=.*\\d)(?=.*[A-Z])(?=.*\\W)(?!.*\\W\\w*\\W)(?!.*\\s).{8,}$";

	static ValidateUser firstNameCheck = (i) -> (Pattern.compile(firstName).matcher(i).matches());
	static ValidateUser lastNameCheck = (i) -> (Pattern.compile(lastName).matcher(i).matches());
	static ValidateUser emailCheck = (i) -> (Pattern.compile(emailAddress).matcher(i).matches());
	static ValidateUser mobileNoCheck = (i) -> (Pattern.compile(mobileNo).matcher(i).matches());
	static ValidateUser passwordCheck = (i) -> (Pattern.compile(password).matcher(i).matches());

	public static void main(String[] args) {

		System.out.println("Firstname validation result : " + firstNameCheck.validateUser("Lalit"));

		System.out.println("Firstname validation result : " + firstNameCheck.validateUser("lalit"));

		System.out.println("Lastname validation result : " + lastNameCheck.validateUser("Gahlawat"));

		System.out.println("Lastname validation result : " + lastNameCheck.validateUser("gahlawat"));

		System.out.println("Email validation result : " + emailCheck.validateUser("lalit.abc@gmail.com.au"));

		System.out.println("Email validation result : " + emailCheck.validateUser("lali@t.abc@gmail.com.au"));

		System.out.println("Mobile Number validation result : " + mobileNoCheck.validateUser("92 1234567899"));

		System.out.println("Mobile Number validation result : " + mobileNoCheck.validateUser("921234567899"));

		System.out.println("Password validation result : " + passwordCheck.validateUser("ADS@as1234"));
		
		System.out.println("Password validation result : " + passwordCheck.validateUser("adsdd@Asd123@1"));
	}

}
