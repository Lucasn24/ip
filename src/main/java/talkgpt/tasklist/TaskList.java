package talkgpt.tasklist;

import talkgpt.task.Task;

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
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < super.size(); i++) {
            String adding = String.format("%d. %s\n", i+1, super.get(i).toString());
            msg.append(adding);
        }

        return msg.toString();
    }

    public TaskList findTask(String keyword) {
        TaskList results = new TaskList();

        for (int i = 0; i < this.size(); i++) {
            Task task = super.get(i);
            String description = task.getDescription();

            if  (description.contains(keyword)) {
                results.add(task);
            }
        }

        return results;
    }
}
