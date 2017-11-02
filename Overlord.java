package matiw51.task_o_inator;
import java.util.ArrayList;

public class Overlord{
    public static int Task_count=0;
    public static int Project_count=0;
    private static ArrayList<Person> All_people = new ArrayList<Person>();
    private static ArrayList<Project> All_projects = new ArrayList<Project>();


    public static void Add_Project(String name) {
        Project p=new Project(name);
        System.out.println("Created project: " + name);
        All_projects.add(p);
    }

    public static Project Get_Project(int id) {
        for(int i=0; i<All_projects.size(); i++) {
            Project p=All_projects.get(i);
            if(id==p.Get_Id()) {
                return(p);
            }
        }
        System.out.println("Project not found");
        return(null);
    }

    public static void Add_Person(String name, String surname, String email) {
        Person p = new Person(name, surname, email);
        All_people.add(p);
    }

    public static Person Get_Person(int id) {
        for(int i=0; i<All_people.size(); i++) {
            Person p=All_people.get(i);
            if(id==p.Get_Id()) {
                return(p);
            }
        }
        System.out.println("Person not found");
        return(null);
    }

    public static int Get_Person_Information(int id) {
        for(int i=0; i<All_people.size(); i++) {
            Person p=All_people.get(i);
            if(id==p.Get_Id()) {
                System.out.println(p.Get_Information());
                return(0);
            }
        }
        System.out.println("Nie znaleziono osoby o zadanym ID");
        return(0);
    }


}
