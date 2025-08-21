import java.util.Objects;
import java.util.Scanner;

public class TalkGPT {
    public static Task[] list = new Task[100];
    public static int index = 0;

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

    public static void formatAdd(Task task) {
        String border = "____________________________________________________________\n";
        String header = "Got it. I've added this task:\n";
        list[index] = task;
        index++;

        String display = String.format("Now you have %d tasks in the list.\n", index);

        System.out.println(border + header + " " + task.toString() + "\n" + display + border);
    }

    public static void main(String[] args) {
        //initialisation
        Scanner scanner = new Scanner(System.in);

        //Introduction
        String intro = "____________________________________________________________\n"
                + "Hello! I'm TalkGPT!\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(intro);

        //getting input
        System.out.print("Would you like to add to the list?: ");
        String input = scanner.nextLine();

        //looping
        while (!Objects.equals(input, "bye")) {
            int firstSpaceIndex = input.indexOf(" ");
            if (firstSpaceIndex == -1) {
                if (Objects.equals(input, "list")) {
                    System.out.print(formatList(list));
                } else {
                    System.out.print("Invalid input");
                }
            } else {
                String command = input.substring(0, firstSpaceIndex);
                String message = input.substring(firstSpaceIndex + 1);

                switch (command) {
                    case "mark" -> {
                        int taskId = Integer.parseInt(message) - 1;

                        list[taskId].mark();

                        String msg = "____________________________________________________________\n"
                                + "Nice! I've marked this task as done: \n" + list[taskId] + "\n"
                                + "____________________________________________________________";
                        System.out.println(msg);
                    }
                    case "unmark" -> {
                        int taskId = Integer.parseInt(message) - 1;

                        list[taskId].unmark();

                        String msg = "____________________________________________________________\n"
                                + "OK, I've marked this task as not done yet: \n" + list[taskId] + "\n"
                                + "____________________________________________________________";
                        System.out.println(msg);
                    }
                    case "todo" -> {
                        formatAdd(new ToDo(message));
                    }
                    case "deadline" -> {
                        String[] parts = message.split("/");
                        String task = parts[0];
                        String due = parts[1].substring(2);

                        formatAdd(new Deadline(task, due));
                    }
                    case "event" -> {
                        String[] parts = message.split("/");
                        String task = parts[0];
                        String from = parts[1].substring(4);
                        String to = parts[2].substring(2);

                        formatAdd(new Event(task, from, to));
                    }
                }
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
