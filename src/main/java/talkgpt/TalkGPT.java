package talkgpt;

import talkgpt.command.Command;
import talkgpt.parser.Parser;
import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class TalkGPT {
    private Storage storage;
    private Ui ui;
    private Parser parser;
    private TaskList list;

    public TalkGPT(String path){
        this.storage = new Storage(path);
        this.ui = new Ui();
        this.parser = new Parser();
        this.list = storage.load();
    }

    public String getResponse(String input){
        try {
            Command c = parser.parse(input);
            return c.execute(list, ui, storage);
        } catch (TalkGPTException e) {
            return e.getMessage();
        }
    }

    public void run(){
        this.ui.welcome();
        boolean isExit = false;

        while(!isExit){
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.execute(list, ui, storage);
                isExit = c.isExit();
            } catch (TalkGPTException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new TalkGPT("C:\\Users\\lucas\\Documents\\IP\\src\\main\\test\\data.txt").run();
    }
}
