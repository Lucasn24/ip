import java.util.Objects;
import java.util.Scanner;

public class TalkGPT {
    public static String formatList(String[] arr) {
        String border = "____________________________________________________________\n";
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) break;

            String adding = String.format("%d. %s\n", i+1, arr[i]);
            msg.append(adding);
        }

        return border + msg + border;
    }

    public static void main(String[] args) {
        //initialisation
        Scanner scanner = new Scanner(System.in);
        String[] list = new String[100];

        //Introduction
        String intro = "____________________________________________________________\n"
                + "Hello! I'm TalkGPT!\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(intro);

        //getting input
        System.out.print("Would you like to add to the list?: ");
        String input = scanner.nextLine();
        int index = 0;

        //looping
        while (!Objects.equals(input, "bye")) {
            if (Objects.equals(input, "list")) {
                System.out.print(formatList(list));
            } else {
                String msg = "____________________________________________________________\n"
                        + "added: " + input + "\n"
                        + "____________________________________________________________";
                list[index] = input;
                index++;
                System.out.println(msg);
            }

            System.out.print("Would you like to add to the list?: ");
            input = scanner.nextLine();
        }

        //goodbye
        String goodbye = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________";
        System.out.println(goodbye);
    }
}
