package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example2;

public class NotificationFactory {

    public static Client getNotificationclient(ClientType clientType) {
        switch (clientType) {
            case MAIL:
                return new EmailNotification(25, "SMTP", "mailnotification.com");
            case MESSAGE:
                return new SmsNotification(443, "HTTPS", "smsnotification.com");
            default:
                return null;
        }
    }

}
