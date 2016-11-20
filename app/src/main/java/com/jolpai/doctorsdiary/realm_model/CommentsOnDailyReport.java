package com.jolpai.doctorsdiary.Realm_Model;

import io.realm.RealmObject;

/**
 * Created by User on 11/13/2016.
 */

public class CommentsOnDailyReport extends RealmObject {

    private String personsName;
    private String comment;
    private int date;

    public String getPersonsName() {
        return personsName;
    }

    public void setPersonsName(String personsName) {
        this.personsName = personsName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
