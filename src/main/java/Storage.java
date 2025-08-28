import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Storage {
    private String path;
    private File file;

    public Storage(String path){
        this.path = path;
        this.file = new File(path);
    }

    public ArrayList<Task> load(){
        File folder = file.getParentFile();
        ArrayList<Task> list = new ArrayList<>();


            return list;

    }
}