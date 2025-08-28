import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Storage {
    private String path;
    private File file;

    public Storage(String path){
        this.path = path;
        this.file = new File(path);
    }

    public TaskList load(){
        File folder = file.getParentFile();
        TaskList list = new TaskList();

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
                list.addTask(Task.deserialize(input));
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

    public void delete(Task task) {
        try {
            String lineToRemove = task.serialize();

            System.out.println("linetoremove: " + lineToRemove);

            //the file in the list
            List<String> lines = Files.readAllLines(Paths.get(path));

            //using streams to filter and remove the thing
            List<String> updatedLines = lines.stream()
                    .filter(line -> !line.equals(lineToRemove))
                    .toList();

            //overwrite the file
            Files.write(Path.of(path), updatedLines);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String oldTask, Task newTask) {
        try {
            String lineToUpdate = newTask.serialize();

            System.out.println("lineToUpdate: " + lineToUpdate);

            System.out.println("lineToRemove: " + oldTask);
            List<String> lines = Files.readAllLines(Paths.get(path));

            List<String> updatedLines = lines.stream()
                    .map(line -> Objects.equals(line, oldTask) ? lineToUpdate : line)
                    .toList();

            Files.write(Path.of(path), updatedLines);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}