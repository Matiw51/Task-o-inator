package matiw51.task_o_inator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

class AssignPersonActivity extends AppCompatActivity {
    PeopleGridAdapter adapter;
    int task_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getIntent().getExtras();
        task_id = bundle.getInt("position");
        setContentView(R.layout.activity_assign_person);
        GridView gv=(GridView) findViewById(R.id.gridView3);
        adapter=new PeopleGridAdapter(this, task_id);
        gv.setAdapter(adapter);
    }

    protected void onStart() {
        super.onStart();
        GridView gv=(GridView) findViewById(R.id.gridView3);
        adapter=new PeopleGridAdapter(this, task_id);
        gv.setAdapter(adapter);
    }

}
