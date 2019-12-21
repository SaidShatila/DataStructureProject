package municipality;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class communicates with the SMS gateway to send the SMSes
 */
public class SMSManager {

    /**
     * This method will use the immplemented SMS gateway to send the SMS with the passed arguments data.
     *
     * @param phoneNumber to destination phone number
     * @param text        body of the SMS
     */
    public static void sendSMS(String phoneNumber, String text) {
        System.out.println("----------------------------------");
        System.out.println("To: " + phoneNumber);
        System.out.println("Body:\n" + text);
        System.out.println("Sent at:" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a").format(new Date()));
        System.out.println("----------------------------------");
    }
}
