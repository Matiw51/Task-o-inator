package matiw51.task_o_inator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MateuszWasilewski on 2017-11-29.
 */

class TasksGridAdapter extends BaseAdapter {
    Context c;
    ArrayList<Task> Tasks;

    public TasksGridAdapter(Context c, ArrayList<Task> Tasks){
        this.c=c;
        this.Tasks=Tasks;
    }

    @Override
    public int getCount() {
        return Tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return Tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.tasks_grid_row,parent, false);
        }

        TextView title=(TextView)convertView.findViewById(R.id.tasknameDisplay);
        TextView description=(TextView)convertView.findViewById(R.id.taskdescriptionDisplay);
        TextView personassigned=(TextView)convertView.findViewById(R.id.personassignedDisplay);

        Button assignpersonButton=(Button)convertView.findViewById(R.id.assignpersonButton);
        Button deletetaskbutton=(Button)convertView.findViewById(R.id.deleteTaskButton);
        final Task t=(Task) this.getItem(position);
        final int pos=position;
        deletetaskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteStuff ds = new DeleteStuff();
                ds.deleteTask(UserData.currentprojectid, pos);
                Intent intent = new Intent(c, ProjectsMenuActivity.class);
                c.startActivity(intent);
            }
        });

        assignpersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, AssignPersonActivity.class);
                intent.putExtra("position", pos);
                c.startActivity(intent);
            }
        });

        title.setText(t.title);
        description.setText(t.description);
        if(t.person_id!=-1)
            personassigned.setText(UserData.People.get(t.person_id).name + " " + UserData.People.get(t.person_id).surname);
        else
            personassigned.setText("No person assigned");


        return convertView;
    }
}
