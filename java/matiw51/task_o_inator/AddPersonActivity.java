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

import static java.lang.String.valueOf;
import static matiw51.task_o_inator.UserData.userId;


class AddPersonActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText name = (EditText) findViewById(R.id.personName);
        final EditText surname = (EditText) findViewById(R.id.personSurname);
        final EditText email = (EditText) findViewById(R.id.personEmail);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewPerson(name.getText().toString(), surname.getText().toString(), email.getText().toString());
                Snackbar.make(view, name.getText().toString() + " " +
                        surname.getText().toString() + " has been added to the app", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void writeNewPerson(String name, String surname, String email) {
        Person person = new Person(name, surname, email);
        myRef.child(userId).child("People").child(valueOf(Person.people_count)).setValue(person);

    }
}