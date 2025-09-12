package talkgpt.ui;

import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;

import java.util.Scanner;

public class Ui {
    Scanner scanner = new Scanner(System.in);

    public Ui() {

    }

    private String formatMessage(String message, int size) {
        String display = String.format("Now you have %d tasks in the list.\n", size);

        return message + display;
    }

    /**
     * prints the welcome page of TalkGPT
     */
    public String welcome(){
        String intro = """                
                Hello! I'm TalkGPT!
                What can I do for you?
                """;
        return intro;
    }

    /**
     * prints the goodbye page of TalkGPT
     */
    public String goodbye(){
        String goodbye = """             
                Bye. Hope to see you again soon!
                """;
        return goodbye;
    }

    /**
     * Reads the next input from the user
     *
     * @return input of the user
     */
    public String readCommand(){
        System.out.print("Would you like to add to the list?: ");

        return scanner.nextLine();
    }

    /**
     * prints the add task message
     *
     * @param task Task to be added
     * @param size Size of the taskList
     */
    public String addTask(Task task, int size){
        String header = "Got it. I've added this task:\n";

        return formatMessage(header + " " + task + "\n", size);
    }

    /**
     * prints the delete task message
     *
     * @param task Task to be deleted
     * @param size Size of the taskList
     */
    public String deleteTask(Task task, int size){
        String msg = "Noted. I've removed this task:\n" + " " + task + "\n";

        return formatMessage(msg, size);
    }

    /**
     * prints the mark task message
     *
     * @param task Task to be marked
     * @param size Size of the taskList
     */
    public String markTask(Task task, int size){
        String msg = "Nice! I've marked this task as done:\n" + " " + task + "\n";

        return formatMessage(msg, size);
    }

    /**
     * prints the unmark task message
     *
     * @param task Task to be unmarked
     * @param size Size of the taskList
     */
    public String unmarkTask(Task task, int size){
        String msg = "OK, I've marked this task as not done yet:\n" + " " + task + "\n";

        return formatMessage(msg, size);
    }

    /**
     * prints the list message
     *
     * @param list List of the TalkGPT
     */
    public String listView(TaskList list){
        String msg = "Here are the tasks in your list:\n" + list + "\n";

        return formatMessage(msg, list.size());
    }

    public String findTask(TaskList tasks) {
        String msg = "Here is the matching tasks in the list:\n" + tasks.toString() + "\n";

        return formatMessage(msg, tasks.size());
    }
}
