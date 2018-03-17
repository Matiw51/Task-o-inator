package matiw51.task_o_inator;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import static matiw51.task_o_inator.UserData.userId;

/**
 * Created by MateuszWasilewski on 2017-12-03.
 */

class DeleteStuff {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    void deleteTask(int project_id, int task_id){
        ArrayList<Task> tasks=UserData.Projects.get(project_id).Tasks;
        tasks.remove(task_id);
        myRef.child(userId).child("Tasks").child(valueOf(project_id)).removeValue();
        myRef.child(userId).child("Tasks").child(valueOf(project_id)).setValue(tasks);
    }

    void deleteProject(int project_id){
        ArrayList<Project> projects=UserData.Projects;
        projects.remove(project_id);
        myRef.child(userId).child("Projects").removeValue();
        myRef.child(userId).child("Projects").setValue(projects);
        myRef.child(userId).child("Tasks").child(valueOf(project_id)).removeValue() ;
    }
}
