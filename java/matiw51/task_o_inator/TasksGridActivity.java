package matiw51.task_o_inator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import static matiw51.task_o_inator.UserData.userId;

class TasksGridActivity extends AppCompatActivity {
    TasksGridAdapter adapter;
    int project_id=UserData.currentprojectid;
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(TasksGridActivity.this, ProjectsMenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_grid);
        GridView gv=(GridView) findViewById(R.id.gridView2);
        adapter=new TasksGridAdapter(this, UserData.Projects.get(project_id).Tasks);
        gv.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GridView gv=(GridView) findViewById(R.id.gridView2);
        adapter=new TasksGridAdapter(this, UserData.Projects.get(project_id).Tasks);
        gv.setAdapter(adapter);
    }


}
