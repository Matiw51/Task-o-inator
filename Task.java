package matiw51.task_o_inator;

/**
 * Created by MateuszWasilewski on 2017-10-20.
 */

public class Task {
    private String Title;
    private String Description;
    private int Person_id;
    private final int Id;
    private Boolean Isdone=false;

    Task(String title,int id){
        this.Title=title;
        this.Description="No description yet.";
        this.Person_id=-1;
        this.Id=id;
        System.out.println("Created task: " + Title);
    }

    public void Assign_Person(int id) {
        this.Person_id=id;
    }

    public void Modify_Title(String title) {
        this.Title=title;
    }

    public void Modify_Description(String description) {
        this.Description=description;
    }

    public void Mark_As_Done() {
        Isdone=true;
    }

    public int Get_Person_Id(){
        return(Person_id);
    }

    public String Get_Information() {
        return("Title: " + this.Title + " Description: " + this.Description + " Person id: " + this.Person_id + " id: " + this.Id + " Is completed? " + this.Isdone);
    }

}
