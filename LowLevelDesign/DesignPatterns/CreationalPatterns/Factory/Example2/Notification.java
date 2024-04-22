package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example2;

public class Notification {

    private final String message;
    private final String header;
    private final String footer;
    private final String recipient;
    private final String sender;

    public Notification(String message, String header, String footer, String recipient, String sender) {
        this.message = message;
        this.header = header;
        this.footer = footer;
        this.recipient = recipient;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

}
