package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example2;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== Email notification ==========");
        Notification emailNotification
                = new Notification("This is the message body of the resignation Email.",
                "Resignation Letter", "signature",
                "hr@gmail.com",
                "harsh@gmail.com");
        Client emailClient = NotificationFactory.getNotificationclient(ClientType.MAIL);
        emailClient.notify(emailNotification);

        System.out.println("\n========== SMS notification ==========");
        Notification smsNotificaiton
                = new Notification("This is the message body of the leave request SMS.",
                "Leave Request", "signature",
                "allhr@gmail.com",
                "harsh@gmail.com");
        Client smsClient = NotificationFactory.getNotificationclient(ClientType.MESSAGE);
        smsClient.notify(smsNotificaiton);

    }

}
