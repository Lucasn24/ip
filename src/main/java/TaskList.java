import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {

    public TaskList(){

    }

    public Task markTask(int index){
        Task task = super.get(index);
        task.mark();

        return task;
    }

    public Task unmarkTask(int index){
        Task task = super.get(index);
        task.unmark();

        return task;
    }

    public Task deleteTask(int index){
        Task task = super.get(index);
        super.remove(index);

        return task;
    }

    public void addTask(Task task){
        super.add(task);
    }

    @Override
    public String toString(){
        String header = "Here are the tasks in your list:\n";
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < super.size(); i++) {
            String adding = String.format("%d. %s\n", i+1, super.get(i).toString());
            msg.append(adding);
        }

        return header + msg;
    }
}
