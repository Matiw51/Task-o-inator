package matiw51.task_o_inator;

import java.util.ArrayList;

/**
 * Created by MateuszWasilewski on 2017-11-22.
 */

class Project {
    ArrayList<Task> Tasks = new ArrayList<>();
    String name;
    String description;

    static int project_count=-1;

    Project(String name) {
        this.name = name;
        project_count++;
    }

}
