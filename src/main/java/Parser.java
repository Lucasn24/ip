import java.util.Objects;
import java.util.Set;

public class Parser {
    public static final Set<String> validCommands = Set.of("mark", "unmark", "todo", "deadline", "event", "list", "delete");

    public Parser(){

    }

    public Command parse(String input) throws TalkGPTException {
        if (!validCommands.contains(input) && input.length() == 1) {
            throw new TalkGPTException("Sorry, I don't recognize that command!");
        }

        if (Objects.equals(input, "list")) {
            return new ListCommand();
        }

        if (input == null) {
            throw new TalkGPTException("The input cannot be empty.");
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String message = parts[1];

        switch (command) {
            case "mark" -> {
                return new MarkCommand(message);
            }
            case "unmark" -> {
                return new UnmarkCommand(message);
            }
            case "todo" -> {
                return new AddCommand(new ToDo(message));
            }
            case "deadline" -> {
                String[] components = message.split(" /by ", 2);
                String task = components[0];
                String stringDate = components[1];

                return new AddCommand(new Deadline(task, stringDate));
            }
            case "event" -> {
                String[] components = message.split(" /from ", 2);
                String task = components[0];

                String[] dates = components[1].split(" /to ", 2);
                String from = dates[0];
                String to = dates[1];

                return new AddCommand(new Event(task, from, to));
            }
            case "delete" -> {
                return new DeleteCommand(message);
            }
            default -> {
                throw new TalkGPTException("Invalid Command.");
            }
        }
    }
}
