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

    public static void main(String[] args) {}
}
