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

    /**
     * prints the welcome page of TalkGPT
     */
    public void welcome(){
        String intro = """
                ____________________________________________________________
                Hello! I'm TalkGPT!
                What can I do for you?
                ____________________________________________________________
                """;
        System.out.println(intro);
    }

    /**
     * prints the goodbye page of TalkGPT
     */
    public void goodbye(){
        String goodbye = """
                ____________________________________________________________
                Bye. Hope to see you again soon!
                
                ____________________________________________________________
                """;
        System.out.print(goodbye);
    }

    /**
     * Reads the next input from the user
     * @return input of the user
     */
    public String readCommand(){
        System.out.print("Would you like to add to the list?: ");

        return scanner.nextLine();
    }

    /**
     * prints the add task message
     * @param task Task to be added
     * @param size Size of the taskList
     */
    public void addTask(Task task, int size){
        String header = "Got it. I've added this task:\n";

        System.out.println(formatMessage(header + " " + task + "\n", size));
    }

    /**
     * prints the delete task message
     * @param task Task to be deleted
     * @param size Size of the taskList
     */
    public void deleteTask(Task task, int size){
        String msg = "Noted. I've removed this task:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    /**
     * prints the mark task message
     * @param task Task to be marked
     * @param size Size of the taskList
     */
    public void markTask(Task task, int size){
        String msg = "Nice! I've marked this task as done:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    /**
     * prints the unmark task message
     * @param task Task to be unmarked
     * @param size Size of the taskList
     */
    public void unmarkTask(Task task, int size){
        String msg = "OK, I've marked this task as not done yet:\n" + " " + task + "\n";

        System.out.println(formatMessage(msg, size));
    }

    /**
     * prints the list message
     * @param list List of the TalkGPT
     */
    public void listView(TaskList list){
        System.out.println(formatMessage(list.toString(), list.size()));
    }
}
