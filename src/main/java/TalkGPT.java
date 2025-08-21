import java.util.Objects;
import java.util.Scanner;

public class TalkGPT {
    public static String formatList(Task[] arr) {
        String border = "____________________________________________________________\n";
        String header = "Here are the tasks in your list:\n";
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) break;

            String adding = String.format("%d. %s\n", i+1, arr[i].toString());
            msg.append(adding);
        }

        return border + header + msg + border;
    }

    public static void main(String[] args) {
        //initialisation
        Scanner scanner = new Scanner(System.in);
        Task[] list = new Task[100];

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
            String[] parts = input.split(" ");
            String firstWord = parts[0];

            if (Objects.equals(input, "list")) {
                System.out.print(formatList(list));
            } else if (Objects.equals(firstWord, "mark")) {
                int taskId = Integer.parseInt(parts[1]) - 1;

                list[taskId].mark();

                String msg = "____________________________________________________________\n"
                        + "Nice! I've marked this task as done: \n" + list[taskId] + "\n"
                        + "____________________________________________________________";
                System.out.println(msg);
            } else if (Objects.equals(firstWord, "unmark")) {
                int taskId = Integer.parseInt(parts[1]) - 1;

                list[taskId].unmark();

                String msg = "____________________________________________________________\n"
                        + "OK, I've marked this task as not done yet: \n" + list[taskId] + "\n"
                        + "____________________________________________________________";
                System.out.println(msg);
            } else {
                list[index] = new Task(input);
                index++;
                String msg = "____________________________________________________________\n"
                        + "added: " + input + "\n"
                        + "____________________________________________________________";

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
