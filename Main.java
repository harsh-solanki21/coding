import java.util.*;

public class Main {

    // Accounts Merge
    static List<List<String>> accountsMerge(List<List<String>> accounts) {

    }


    public static void main(String[] args) {
        String[][] accountsArr = {
                {"John", "j1@mail.com", "j2@mail.com", "j3@mail.com"},
                {"John", "j4@mail.com"},
                {"Fern", "f5@m.co", "f1@m.co", "f0@m.co"},
                {"Mary", "m1@mail.com"},
                {"John", "j1@mail.com", "j5@mail.com"},
                {"Fern", "f4@m.co", "f1@m.co"},
        };

        List<List<String>> accounts = new ArrayList<>();
        for (String[] i : accountsArr) {
            accounts.add(Arrays.asList(i));
        }

        System.out.println(accountsMerge(accounts));
    }

}
