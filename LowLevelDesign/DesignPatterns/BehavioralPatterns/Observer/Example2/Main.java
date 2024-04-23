package LowLevelDesign.DesignPatterns.BehavioralPatterns.Observer.Example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        YoutubeChannel channel = new YoutubeChannel();

        Subscriber harsh = new Subscriber("Harsh");
        Subscriber nisarg = new Subscriber("Nisarg");

        channel.subscribe(harsh);
        channel.subscribe(nisarg);

        channel.newVideoUpload("Learn Design Patterns");
        channel.newVideoUpload("Learn System Design");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("Press 1 to Upload Video");
            System.out.println("Press 2 to Create new Subscriber");
            System.out.println("Press 3 to Unsubscribe");
            System.out.println("Press 4 to Exit");
            int input = Integer.parseInt(br.readLine());

            switch (input) {
                case 1:
                    System.out.println("Enter Video Title");
                    String videoTitle = br.readLine();
                    channel.newVideoUpload(videoTitle);
                    break;

                case 2:
                    System.out.println("Enter Subscriber Name");
                    String subscriberName = br.readLine();
                    Subscriber subscriber = new Subscriber(subscriberName);
                    channel.subscribe(subscriber);
                    break;

                case 3:
                    System.out.println("Enter Subscriber Name to Unsubscribe");
                    String unsubscribeName = br.readLine();
                    boolean unsubscribed = false;
                    for (Observer sub : channel.subscribers) {
                        if (sub instanceof Subscriber && ((Subscriber) sub).name.equalsIgnoreCase(unsubscribeName)) {
                            channel.unsubscribe(sub);
                            unsubscribed = true;
                            break;
                        }
                    }

                    if (!unsubscribed) {
                        System.out.println("Subscriber Not Found.");
                    } else {
                        System.out.println(unsubscribeName + " unsubscribed successfully.");
                    }

                    break;

                case 4:
                    System.out.println("THANK YOU");
                    System.exit(0);
                    break;

                default:
                    System.out.println("WRONG INPUT!");
                    System.exit(1);
                    break;

            }

        }

    }

}
