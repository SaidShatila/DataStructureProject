package municipality;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

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
        Twilio.init("ACd7cc129918dcccee42ec999f35e2508b", "3f671c2a3cbc0d256281be17dc10d7c6");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phoneNumber),
                new com.twilio.type.PhoneNumber("+13102992366"),
                text)
                .create();
        message.getStatus();
        System.out.println("----------------------------------");
        System.out.println("To: " + phoneNumber);
        System.out.println("Body:\n" + text);
        System.out.println("Sent at:" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a").format(new Date()));
        System.out.println("----------------------------------");
    }
}
