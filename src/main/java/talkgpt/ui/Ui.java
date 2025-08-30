package talkgpt.ui;

import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;

import java.util.Scanner;

public class Ui {
    Scanner scanner = new Scanner(System.in);

    public Ui() {

    }

    private String formatMessage(String message, int size) {
        String border = "____________________________________________________________\n";
        String display = String.format("Now you have %d tasks in the list.\n", size);

        return border + message + display + border;
    }

    public void welcome(){
        String intro = """
                ____________________________________________________________
                Hello! I'm TalkGPT!
                What can I do for you?
                ____________________________________________________________
                """;
        System.out.println(intro);
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

    public void addTask(Task task, int size){
        String header = "Got it. I've added this task:\n";

        System.out.println(formatMessage(header + " " + task + "\n", size));
    }

    public void deleteTask(Task task, int size){
        String msg = "Noted. I've removed this task:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    public void markTask(Task task, int size){
        String msg = "Nice! I've marked this task as done:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    public void unmarkTask(Task task, int size){
        String msg = "OK, I've marked this task as not done yet:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    public void listView(TaskList list){
        String msg = "Here are the tasks in your list:\n" + list + "\n";

        System.out.println(formatMessage(msg, list.size()));
    }

    public void findTask(TaskList tasks) {
        String msg = "Here is the matching tasks in the list:\n" + tasks.toString() + "\n";

        System.out.println(formatMessage(msg, tasks.size()));
    }
}
