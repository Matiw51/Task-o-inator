package matiw51.task_o_inator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static matiw51.task_o_inator.UserData.userId;

class    MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference projectsRef = database.getReference().child(userId).child("Projects");
    DatabaseReference peopleRef = database.getReference().child(userId).child("People");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        peopleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                UserData.People.clear();
                Person.people_count=-1;
                for (DataSnapshot ds : datasnapshot.getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    String surname = ds.child("surname").getValue(String.class);
                    String email = ds.child("email").getValue(String.class);
                    new Person(name, surname, email);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        projectsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {
                UserData.Projects.clear();
                Project.project_count=-1;
                datasnapshot.getValue();
                for (DataSnapshot ds : datasnapshot.getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    Project project = new Project(name);
                    UserData.Projects.add(project);
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createProject(View view) {
        Intent intent = new Intent(this, AddProjectActivity.class);
        startActivity(intent);
    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }
    public void yourProjects(View view){
        Intent intent = new Intent(this, ProjectsGridActivity.class);
        startActivity(intent);
    }
    public void signOut(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
