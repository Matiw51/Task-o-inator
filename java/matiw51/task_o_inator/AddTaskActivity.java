package matiw51.task_o_inator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import static matiw51.task_o_inator.UserData.currentprojectid;
import static matiw51.task_o_inator.UserData.userId;

class AddTaskActivity extends AppCompatActivity {
int project_id=UserData.currentprojectid;
FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText title = (EditText) findViewById(R.id.taskName);
        final EditText description=(EditText) findViewById(R.id.taskDescription);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewTask(title.getText().toString(), description.getText().toString());
                Snackbar.make(view, title.getText().toString() + " " + "has been created", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void writeNewTask(String title, String description) {
        Task task=new Task(title, description);
        myRef.child(userId).child("Tasks").child(valueOf(project_id)).child(valueOf(Task.task_count)).setValue(task);
    }

}