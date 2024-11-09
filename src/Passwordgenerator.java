import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import static com.sun.tools.javac.comp.CompileStates.CompileState.LOWER;


public class Passwordgenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER= "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()$#@@@@44";
    


    public static String generatePassowrd(int length,boolean userUpper,boolean useLower,boolean useDigits,boolean useSpecial) throws NoSuchAlgorithmException {
        if (length<=0){
            throw new IllegalArgumentException("password length must be greater than 0");

        }
        StringBuilder character = new StringBuilder();
        if (userUpper) character.append(UPPER);
        if (useLower) character.append(LOWER);
        if (useDigits) character.append(DIGITS);
        if (useSpecial) character.append(SPECIAL);

        if (character.length()==0){
            throw new IllegalArgumentException("At least one character type (upper,lower,digits,special)must be selected");

        }

        Random random;
        try{
            random = SecureRandom.getInstanceStrong(); // Strong crytographic random number generator
        } catch (NoSuchAlgorithmException e){
            random = new SecureRandom();

        }

        StringBuilder password = new StringBuilder(length);
        for (int i =0; i<length;i++){
            int randomIndex = random.nextInt(character.length());
            password.append(character.charAt(randomIndex));
        }
        return password.toString();
    }
    public static void main(String[]args) throws NoSuchAlgorithmException {
        int length = 12; // change desired password length
        boolean useUpper = true;
        boolean useLower = true;
        boolean useDigits = true;
        boolean useSpecial = true;

        String  password = generatePassowrd(length,useUpper,useLower,useDigits,useSpecial);
        System.out.println("Generated  Password:"+password);
    }
}
