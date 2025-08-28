import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class TalkGPT {
    public static Storage storage = new Storage("C:\\Users\\lucas\\Documents\\IP\\src\\main\\test\\data.txt");
    public static ArrayList<Task> list = storage.load();
    public static final String border = "____________________________________________________________\n";
    public static final Set<String> validCommands = Set.of("mark", "unmark", "todo", "deadline", "event", "list", "delete");


    public static String formatList() {
        String header = "Here are the tasks in your list:\n";
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            String adding = String.format("%d. %s\n", i+1, list.get(i).toString());
            msg.append(adding);
        }

        return formatMessage(header + msg);
    }

    public static void formatAdd(Task task) {
        String header = "Got it. I've added this task:\n";
        list.add(task);
        storage.save(task);

        String display = String.format("Now you have %d tasks in the list.\n", list.size());

        System.out.println(formatMessage(header + " " + task + "\n" + display));
    }

    public static String formatMessage(String message) {
        return border + message + border;
    }

    public static void main(String[] args) {
        //initialisation
        Scanner scanner = new Scanner(System.in);

        //Introduction
        String intro = """
                Hello! I'm TalkGPT!
                What can I do for you?
                """;
        
        System.out.println(formatMessage(intro));

        //getting input
        System.out.print("Would you like to add to the list?: ");
        String input = scanner.nextLine();

        //looping
        while (!Objects.equals(input, "bye")) {
            try {
                int firstSpaceIndex = input.indexOf(" ");
                if (firstSpaceIndex == -1) {
                    if (Objects.equals(input, "list")) {
                        System.out.println(formatList());
                    } else {
                        if (!validCommands.contains(input)) {
                            throw new TalkGPTException("Sorry, I don't recognize that command!");
                        } else {
                            throw new TalkGPTException("The description of a " + input + " cannot be empty.");
                        }
                    }
                } else {
                    String command = input.substring(0, firstSpaceIndex);
                    String message = input.substring(firstSpaceIndex + 1);

                    switch (command) {
                        case "mark" -> {
                            int taskId = Integer.parseInt(message) - 1;
                            Task task = list.get(taskId);
                            task.mark();

                            String msg = "Nice! I've marked this task as done:\n" + " " + task + "\n";
                            
                            System.out.println(formatMessage(msg));
                        }
                        case "unmark" -> {
                            int taskId = Integer.parseInt(message) - 1;
                            Task task = list.get(taskId);
                            task.unmark();

                            String msg = "OK, I've marked this task as not done yet:\n" + " " + task + "\n";
                            
                            System.out.println(formatMessage(msg));
                        }
                        case "delete" -> {
                            int taskId = Integer.parseInt(message) - 1;
                            Task task = list.get(taskId);
                            list.remove(taskId);

                            String msg = "Noted. I've removed this task:\n" + " " + task + "\n"
                                    + "Now you have " + list.size() + " tasks in the list.\n";                            
                            
                            System.out.println(formatMessage(msg));
                        }
                        case "todo" -> formatAdd(new ToDo(message));
                        case "deadline" -> {
                            String[] parts = message.split("/");
                            String task = parts[0];
                            String due = parts[1];

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
            } catch (TalkGPTException e) {
                System.out.println(formatMessage(e.getMessage() + "\n"));
            } finally {
                System.out.print("Would you like to add to the list?: ");
                input = scanner.nextLine();
            }
        }

        //goodbye
        String goodbye = "Bye. Hope to see you again soon!\n";
        System.out.print(formatMessage(goodbye));
        scanner.close();
    }
}
