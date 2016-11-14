package com.jolpai.doctorsdiary.realm_model;

import io.realm.RealmObject;

/**
 * Created by User on 10/18/2016.
 */

public class PlanForMonth extends RealmObject {
    private String year;
    private String month;
    private String planDate;
    private String intentDate;
    private String contactDate;
    private String type;
    private String targetName;

    private String appUser;



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getIntentDate() {
        return intentDate;
    }

    public void setIntentDate(String intentDate) {
        this.intentDate = intentDate;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }
}
