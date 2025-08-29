import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class Storage {
    private String path;
    private File file;
    private TaskList list = new TaskList();

    public Storage(String path){
        this.path = path;
        this.file = new File(path);
    }

    public TaskList load(){
        File folder = file.getParentFile();

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
            writer.write(task.serialize() + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reset(){
        try (FileWriter writer = new FileWriter(path, false)) { // 'false' to overwrite the file
            // Do nothing or write a header if needed; this clears the file's contents
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int index) {
        this.reset();
        for (Task addTask : list) {
            this.save(addTask);
        }
    }

    public void update(String oldTask, Task newTask) {
        try {
            String lineToUpdate = newTask.serialize();
            Task outdatedTask = Task.deserialize(oldTask);

            int index = list.indexOf(outdatedTask);

            if (index != -1){
                list.set(index, newTask);
            }

            this.reset();

            for (Task task : list) {
                this.save(task);
            }

        } catch (TalkGPTException e) {
            System.out.println(e.getMessage());
        }
    }
}