package matiw51.task_o_inator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by MateuszWasilewski on 2017-11-23.
 */

class ProjectsGridAdapter extends BaseAdapter {
    Context c;
    ArrayList<Project> Projects;

    ProjectsGridAdapter(Context c, ArrayList<Project> Projects){
        this.c=c;
        this.Projects=Projects;
    }

    @Override
    public int getCount() {
        return Projects.size();
    }

    @Override
    public Object getItem(int position) {
        return Projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.projects_grid_row,parent, false);
        }

        TextView nameText=(TextView)convertView.findViewById(R.id.displayProjectName);

        Button getProjectButton=(Button)convertView.findViewById(R.id.openButton);
        Button deleteProjectButton=(Button)convertView.findViewById(R.id.deleteProjectButton);

        final Project p=(Project) this.getItem(position);
        final int pos=position;
        getProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, ProjectsMenuActivity.class);
                UserData.currentprojectid=pos;
                UserData.currentprojectname=p.name;
                c.startActivity(intent);
            }
        });

        deleteProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteStuff ds=new DeleteStuff();
                ds.deleteProject(pos);
                Intent intent = new Intent(c, MainActivity.class);
                c.startActivity(intent);
            }
        });
        nameText.setText(p.name);

        return convertView;
    }
}
