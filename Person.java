package matiw51.task_o_inator;
import java.util.ArrayList;
/**
 * Created by MateuszWasilewski on 2017-10-20.
 */

public class Person{
    private ArrayList<Integer> Tasks = new ArrayList<Integer>();
    private String Name;
    private String Surname;
    private String Email;
    private final int Id;
    private static int User_count=0;

    Person(String name, String surname, String email){
        Name=name;
        Surname=surname;
        Email=email;
        Id=User_count;
        User_count++;
    }

    public int Get_Id() {
        return Id;
    }

    public String Get_Information(){
        return(this.Name + " " + this.Surname + " " + this.Email);
    }

    public String Get_Name(){
        return(this.Name + " " + this.Surname);
    }

    void Add_Task(int task_id) {
        Tasks.add(task_id);
    }

    void Remove_Task(int task_id) {
        for(int i=0; i<Tasks.size(); i++) {
            int id=Tasks.get(i);
            if(id==task_id) {
                Tasks.remove(i);
            }
        }
    }

    void Display_Task_List() {
        for(int i=0; i<Tasks.size(); i++) {
            System.out.println(Tasks.get(i));
        }
    }
}
