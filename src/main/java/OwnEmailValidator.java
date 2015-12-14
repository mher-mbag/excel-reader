import org.apache.commons.validator.EmailValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mher on 12/8/2015.
 */
public class OwnEmailValidator extends EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public OwnEmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }

    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            if(isValid(email) && doesHostExist(email))  {

                InternetAddress emailAddress = new InternetAddress(email);
                emailAddress.validate();
            } else {
                return false;
            }
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public boolean doesHostExist(String email) {
        String host = email.substring(email.indexOf("@")+1);
        try {
            Inet4Address.getByName(host);
        } catch (UnknownHostException e) {
            System.out.println("[mail validation] host of mail does not exist email="+email +" - "+ e.getMessage());
            return false;
        }
        return true;
    }
}
