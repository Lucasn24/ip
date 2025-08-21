import java.util.Objects;
import java.util.Scanner;

public class TalkGPT {
    public static void main(String[] args) {
        //Introduction
        String intro = "____________________________________________________________\n"
                + "Hello! I'm TalkGPT!\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(intro);

        //getting input
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Ask a question?: ");
        String input = scanner.nextLine();

        while (!Objects.equals(input, "bye")) {
            String goodbye = "____________________________________________________________\n"
                    + input + "\n"
                    + "____________________________________________________________";
            System.out.println(goodbye);

            //System.out.print("Ask a question?: ");
            input = scanner.nextLine();
        }

        //goodbye
        String goodbye = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________";
        System.out.println(goodbye);
    }
}
