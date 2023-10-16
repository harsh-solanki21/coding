import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.swing.*;

class ActiveScreenScript extends Frame implements ActionListener {
    // Frame
    static JFrame f;

    // textField
    static TextField x, y, z;

    ActiveScreenScript() {
    }

    // when button is pressed
    public void actionPerformed(ActionEvent e) {
        try {
            Robot r = new Robot();
            int xi1, yi1, xi, yi;

            // get initial location
            Point p = MouseInfo.getPointerInfo().getLocation();
            xi = p.x;
            yi = p.y;

            // get x and y points
            xi1 = Integer.parseInt(x.getText());
            yi1 = Integer.parseInt(y.getText());
            int count = Integer.parseInt(z.getText());
            int i = xi, j = yi;

            List<Long> elapsedTimes = new ArrayList<>();  // contains the time taken for all iterations.
            long startTime = Calendar.getInstance().getTimeInMillis();
            long elapsedTime = startTime;
            for (int c = 1; c <= count; c++) {
                System.out.println("------" + c + "------");
                System.out.println("i= " + i);
                System.out.println("j= " + j);
                System.out.println("xi1= " + xi1);
                System.out.println("yi1= " + yi1);
                // slowly move the mouse to defined location
                while (i != xi1 || j != yi1) {
                    // move the mouse to the other point
                    r.mouseMove(i, j);

                    if (i < xi1) {
                        i++;
                    }
                    if (j < yi1) {
                        j++;
                    }

                    if (i > xi1) {
                        i--;
                    }
                    if (j > yi1) {
                        j--;
                    }

                    // wait
                    Thread.sleep(100);
                }
                i = xi1;
                j = yi1;
                xi1 = randomNumber();
                yi1 = randomNumber();
                long currTime = Calendar.getInstance().getTimeInMillis();
                elapsedTimes.add(currTime - elapsedTime);
                elapsedTime = currTime;
                alt_tab();
            }

            long endTime = Calendar.getInstance().getTimeInMillis();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);
        } catch (Exception evt) {
            System.err.println(evt.getMessage());
        }
    }

    public int randomNumber() {
        Random rnd = new Random();
        return 100 + rnd.nextInt(1000);
    }

    public static void alt_tab() {
        Robot robot;

        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(3000);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // main function
    public static void main(String[] args) {
        // object of class
        ActiveScreenScript rm = new ActiveScreenScript();

        // create a frame
        f = new JFrame("robomouse");

        // set the frame to close on exit
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create text-field
        x = new TextField(7);
        y = new TextField(7);
        z = new TextField(7);

        // create a button
        Button b = new Button("OK");

        // add actionListener
        b.addActionListener(rm);

        // create a panel
        Panel p = new Panel();

        // add items to panel
        p.add(x);
        p.add(y);
        p.add(z);
        p.add(b);

        f.add(p);

        // set size of frame
        f.setSize(300, 300);

        f.show();
    }

}