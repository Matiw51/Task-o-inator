package matiw51.task_o_inator;
import java.util.ArrayList;
/**
 * Created by MateuszWasilewski on 2017-10-20.
 */

public class Project{
    private ArrayList<Person> People = new ArrayList<Person>();
    private ArrayList<Task> Tasks = new ArrayList<Task>();
    private String Name;
    private final int Project_id;

    Project(String name){
        this.Name=name;
        Project_id=Overlord.Project_count;
        Overlord.Project_count++;
    }

    public int Get_Id() {
        return Project_id;
    }

    public void Create_Task(String name) {
        int id=Overlord.Task_count;
        Task task=new Task(name, id);
        Tasks.add(task);
        Overlord.Task_count++;
    }

    public void Assign_Task(int person_id, int task_id) {
        Tasks.get(task_id).Assign_Person(person_id);
        People.get(person_id).Add_Task(task_id);
    }

    public void Mark_As_Done(int task_id) {
        Task task=Tasks.get(task_id);
        int person_id=task.Get_Person_Id();
        Person person=People.get(person_id);
        task.Mark_As_Done();
        person.Remove_Task(task_id);
    }


    public void Add_Person(int person_id) {
        Person p = Overlord.Get_Person(person_id);
        People.add(p);
        System.out.println("Added person " + p.Get_Name() + " to the project " + Name);
    }


    public void Display_Information() {
        for(int i=0; i<People.size(); i++) {
            System.out.println(People.get(i).Get_Information());
        }
        for(int i=0; i<Tasks.size(); i++) {
            System.out.println(Tasks.get(i).Get_Information());
        }
    }


}