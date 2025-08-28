import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
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

        try {
            if (!folder.exists()){
                folder.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            //initialise
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                String input = sc.nextLine();
                list.add(Task.deserialize(input));
            }

            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return list;
        }
    }

    public void save(Task task){
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(task.serialize());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}