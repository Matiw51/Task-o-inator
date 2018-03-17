package matiw51.task_o_inator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;



class ProjectsGridActivity extends AppCompatActivity {
    ProjectsGridAdapter adapter;

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ProjectsGridActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_grid);
        GridView gv=(GridView) findViewById(R.id.gridView);
        adapter=new ProjectsGridAdapter(this, UserData.Projects);
        gv.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GridView gv=(GridView) findViewById(R.id.gridView);
        adapter=new ProjectsGridAdapter(this, UserData.Projects);
        gv.setAdapter(adapter);
    }

}
