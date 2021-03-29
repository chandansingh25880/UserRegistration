package com.registration;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lamda {
	public static final String firstNameRegExpPattern =  "^[A-Z][a-zA-Z]{3,3}";
	public static final String lastNameRegExpPattern =  "^[A-Z][a-zA-Z]{3,3}";
	public static final String emailRegExpPattern =  "^([^\\.][a-zA-Z]+[\\.+_-]{0,1}[0-9]*[^\\.]@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}[\\.]*[a-z^la]*)$";
	public static final String mobileFormatRegExpPattern =  "^(91\\s*[7-9][0-9]{9})$";
	public static final String passwordRulesRegExpPattern =  "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#&()-[{}]:;',?/~$^+=<>]).{8,8}$";

	interface ValidatePattern {
	      boolean operation(String a, String b) throws UserValidationException ;
	   }
	static ValidatePattern validatepattern = (argument,regExp) ->{
		    Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(argument);
			if(matcher.matches()) {
				return true;
			}else {
					throw new UserValidationException("please enter valid input which is not null");

			}
	}

public static boolean validatePattern(String argument, String regExp) throws UserValidationException {
	return validatepattern.operation(argument, regExp);

}
public static void ifValidOuput(String regExpString, String[] testSamples) {
	Arrays.stream(testSamples).forEach( testString -> {
		try {
			if (validatePattern(testString, regExpString)) {
				System.out.println(" Valid : ");
			}else
				System.out.println(" Invalid : ");
		} catch (UserValidationException e) {
			System.out.println(e.getMessage());
		}
	}
			
}

	public static void main(String[] args) {
		System.out.println("Welcome to User Registration system to ensure all Validations");
		System.out.println("Enter your first name");
		String[] firstName = {"Chandan", "Smith", "Aisha"};
		ifValidOuput(firstNameRegExpPattern, firstName);

		System.out.println("Enter your last name");
		String[] lastName = {"Singh", "jaiswal", "Thakur"};
		ifValidOuput(lastNameRegExpPattern, lastName);

		System.out.println("Enter your email");
		String[] email = {"chadan@gmail.com", "singhsmith6sep@gmail.com", "aishaaish@yahoo.com"};
		ifValidOuput(emailRegExpPattern, email);

        System.out.println("Enter your mobile format");
        String[] mobileFormat = {"91 8887719063", "91 8419042580", "91 9838114599"};
		ifValidOuput(mobileFormatRegExpPattern, mobileFormat);

		System.out.println("Enter your password rules");
		String[] passwordRules = {"chandan@34", "singh1997@", "aisha@3"};
		ifValidOuput(passwordRulesRegExpPattern, passwordRules);



	}

}  