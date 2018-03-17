package matiw51.task_o_inator;

import java.util.Date;

/**
 * Created by MateuszWasilewski on 2017-11-27.
 */

 class Task {
    static int task_count = -1;
    String title;
    String description;
    String priority;
    Date date;
    int person_id=-1;


    Task(String title, String description) {
        this.title=title;
        this.description=description;
        task_count++;
    }
}