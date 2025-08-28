import java.util.Scanner;

public class Ui {
    Scanner scanner = new Scanner(System.in);

    Ui() {

    }

    private String formatMessage(String message) {
        String border = "____________________________________________________________\n";
        String display = String.format("Now you have %d tasks in the list.\n", list.size());

        return border + message + display + border;
    }

    public void welcome(){
        String intro = """
                Hello! I'm TalkGPT!
                What can I do for you?
                """;
        System.out.println(formatMessage(intro));
    }

    public void goodbye(){
        String goodbye = """
                ____________________________________________________________
                Bye. Hope to see you again soon!
                
                ____________________________________________________________
                """;
        System.out.print(goodbye);
    }

    public String readCommand(){
        System.out.print("Would you like to add to the list?: ");

        return scanner.nextLine();
    }

    public void addTask(Task task){
        String header = "Got it. I've added this task:\n";

        System.out.println(formatMessage(header + " " + task + "\n"));
    }

    public void deleteTask(Task task){
        String msg = "Noted. I've removed this task:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg));
    }

    public void markTask(Task task){
        String msg = "Nice! I've marked this task as done:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg));
    }

    public void unmarkTask(Task task){
        String msg = "OK, I've marked this task as not done yet:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg));
    }
}
