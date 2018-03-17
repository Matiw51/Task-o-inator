package matiw51.task_o_inator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Created by MateuszWasilewski on 2017-11-29.
 */

class PeopleGridAdapter extends BaseAdapter {
    Context c;
    int tasknumber;
    ArrayList<Person> People=UserData.People;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child(UserData.userId);

    PeopleGridAdapter(Context c, int tasknumber){
        this.c=c;
        this.tasknumber=tasknumber;
    }

    @Override
    public int getCount() {
        return People.size();
    }

    @Override
    public Object getItem(int position) {
        return People.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.people_grid_row,parent, false);
        }

        TextView name=(TextView)convertView.findViewById(R.id.assignpersonName);
        TextView surname=(TextView)convertView.findViewById(R.id.assignpersonSurname);



        final Person p=(Person) this.getItem(position);
        final int pos = position;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData.Projects.get(UserData.currentprojectid).Tasks.get(tasknumber).person_id=pos;
                myRef.child("Tasks").child(valueOf(UserData.currentprojectid)).child(valueOf(tasknumber)).child("person_id").setValue(pos);
                Intent intent = new Intent(c, TasksGridActivity.class);
                c.startActivity(intent);
            }
        });
        name.setText(p.name);
        surname.setText(p.surname);


        return convertView;
    }
}
