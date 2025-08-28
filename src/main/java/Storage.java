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

        if (folder.exists()){
            //initalise
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                String input = sc.nextLine();
                list.add(Task.deserialize(input));
            }
            
            return list;
        } else {
            folder.mkdirs();
            return list;
        }
    }
}