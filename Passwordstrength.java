package passwordstrength;

import java.util.Scanner;

public class Passwordstrength {

    public static void main(String[] args) {
        System.out.println("\n\t\tDataFlair's Password Strength Checker\n");
        System.out.print("Enter the password: ");
        
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        
        String strength = passwordStrength(password);
        System.out.println("Strength: " + strength);
        
        sc.close(); 
    }

    public static String passwordStrength(String pass) {
        boolean containsLowerChar = false, containsUpperChar = false;
        boolean containsDigit = false, containsSpecialChar = false, minLength = false;

        String special_chars = "!(){}[]:;<>?,@#$%^&*+=_-~`|./'";
        char[] ch = pass.toCharArray();

        for (char c : ch) {
            if (Character.isLowerCase(c)) containsLowerChar = true;
            if (Character.isUpperCase(c)) containsUpperChar = true;
            if (Character.isDigit(c)) containsDigit = true;
            if (special_chars.contains(String.valueOf(c))) containsSpecialChar = true;
        }

        if (pass.length() >= 12) minLength = true;

        if (minLength && containsDigit && containsUpperChar && containsSpecialChar && containsLowerChar) {
            return "Strong";
        } else if (minLength && ((containsUpperChar && containsLowerChar) || containsDigit || containsSpecialChar)) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
}
