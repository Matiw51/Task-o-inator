package matiw51.task_o_inator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static matiw51.task_o_inator.UserData.userId;

class ProjectsMenuActivity extends AppCompatActivity {
    int project_id=UserData.currentprojectid;
    String name;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference tasksRef = database.getReference().child(userId).child("Tasks").child(valueOf(project_id));

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ProjectsMenuActivity.this, ProjectsGridActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tasksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                Task.task_count=-1;
                UserData.Projects.get(project_id).Tasks.clear();
                for (DataSnapshot ds : datasnapshot.getChildren()) {
                    String title = ds.child("title").getValue(String.class);
                    String description = ds.child("description").getValue(String.class);
                    int person_id = ds.child("person_id").getValue(int.class);
                    Task task = new Task(title, description);
                    task.person_id=person_id;
                    UserData.Projects.get(project_id).Tasks.add(task);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        name=UserData.currentprojectname;
        //String posstring=Integer.toString(project_id);
        //Toast.makeText(ProjectsMenuActivity.this, posstring, Toast.LENGTH_LONG).show();

        Project p=UserData.Projects.get(project_id);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_menu);

        TextView projectname=(TextView)findViewById(R.id.currenrProjectName);
        projectname.setText(name);

        Button addTaskButton = (Button)findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectsMenuActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        Button browseTasksButton=(Button)findViewById(R.id.browseTasksButton);
        browseTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectsMenuActivity.this, TasksGridActivity.class);
                startActivity(intent);
            }
        });
    }

}

