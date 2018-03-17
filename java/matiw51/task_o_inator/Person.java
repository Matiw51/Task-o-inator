package matiw51.task_o_inator;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

/**
 * Created by MateuszWasilewski on 2017-11-21.
 */

@IgnoreExtraProperties
class Person {
    static int people_count=-1;
    String name;
    String surname;
    String email;

    public Person() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    Person(String name, String surname, String email) {
        this.name = name;
        this.surname=surname;
        this.email = email;
        people_count++;
        UserData.People.add(this);
    }

}