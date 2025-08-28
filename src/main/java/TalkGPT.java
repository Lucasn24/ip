import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

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

    public void run(){
        this.ui.welcome();
        boolean isExit = false;

        while(!isExit){
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.execute(list, ui, storage);
                isExit = c.isExit();
            }  catch (TalkGPTException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new TalkGPT("/Users/lucas/ip/src/main/test/data.txt").run();
    }
}
