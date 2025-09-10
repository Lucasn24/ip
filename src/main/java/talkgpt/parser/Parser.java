package talkgpt.parser;

import talkgpt.TalkGPTException;
import talkgpt.command.*;
import talkgpt.task.*;

import java.util.Objects;
import java.util.Set;

public class Parser {
    public static final Set<String> validCommands = Set.of("mark", "unmark", "todo", "deadline",
            "event", "list", "delete", "bye", "find");

    public Parser(){

    }

    public Command parse(String input) throws TalkGPTException {
        if (!validCommands.contains(input) && input.length() == 1) {
            throw new TalkGPTException("Sorry, I don't recognize that command!");
        }

        if (Objects.equals(input, "list")) {
            return new ListCommand();
        }

        if (Objects.equals(input, "bye")) {
            return new GoodbyeCommand();
        }

        if (input == null) {
            throw new TalkGPTException("The input cannot be empty.");
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        assert parts.length > 1 : "The input cannot be a single word";
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
            case "find" -> {
                return new FindCommand(message);
            }
            case "deadline" -> {
                String[] components = message.split(" /by ", 2);
                assert components.length > 1 : "The deadline command is missing a /by field";
                
                String task = components[0];
                String stringDate = components[1];

                return new AddCommand(new Deadline(task, stringDate));
            }
            case "event" -> {
                String[] components = message.split(" /from ", 2);
                String task = components[0];
                assert components.length > 1 : "The event command is missing a /from field";

                String[] dates = components[1].split(" /to ", 2);
                assert dates.length > 1 : "The event command is missing a /to field";

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
