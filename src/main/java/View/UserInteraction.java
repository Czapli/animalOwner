package View;

import java.util.Scanner;

public class UserInteraction {
    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static int inputInt() {
        int userChose = 0;
        boolean end = false;
        do {
            try {
                userChose = Integer.parseInt(scanner.nextLine());
                end = true;
            } catch (NumberFormatException e) {
                System.out.println("It's should be number");
                end = false;
            }
        } while (!end);
        return userChose;
    }
}
