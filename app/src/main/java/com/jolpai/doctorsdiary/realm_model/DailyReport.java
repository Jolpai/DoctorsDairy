package com.jolpai.doctorsdiary.Realm_Model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by User on 11/13/2016.
 */

public class DailyReport extends RealmObject implements Serializable{
    private String date;
    private int toDay;
    private int month;
    private int year;
    private  int professionalWork;
    private int academicStudy;
    private boolean quranStudy;
    private int hadithStudy;
    private int literatureStudy;
    private int salatwithJamaat;
    private int participantIntentContact;
    private int volunteerIntentContact;
    private int memberIntentContact;
    private int contact;
    private int bookDistribution;
    private boolean familyMeeting;
    private double societyWork;
    private boolean visit;
    private boolean reportKeeping;
    private boolean selfAssessment;



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getToDay() {
        return toDay;
    }

    public void setToDay(int doDay) {
        this.toDay = doDay;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getProfessionalWork() {
        return professionalWork;
    }

    public void setProfessionalWork(int professionalWork) {
        this.professionalWork = professionalWork;
    }

    public int getAcademicStudy() {
        return academicStudy;
    }

    public void setAcademicStudy(int academicStudy) {
        this.academicStudy = academicStudy;
    }

    public boolean isQuranStudy() {
        return quranStudy;
    }

    public void setQuranStudy(boolean quranStudy) {
        this.quranStudy = quranStudy;
    }

    public int getHadithStudy() {
        return hadithStudy;
    }

    public void setHadithStudy(int hadithStudy) {
        this.hadithStudy = hadithStudy;
    }

    public int getLiteratureStudy() {
        return literatureStudy;
    }

    public void setLiteratureStudy(int literatureStudy) {
        this.literatureStudy = literatureStudy;
    }

    public int getSalatwithJamaat() {
        return salatwithJamaat;
    }

    public void setSalatwithJamaat(int salatwithJamaat) {
        this.salatwithJamaat = salatwithJamaat;
    }

    public int getParticipantIntentContact() {
        return participantIntentContact;
    }

    public void setParticipantIntentContact(int participantIntentContact) {
        this.participantIntentContact = participantIntentContact;
    }

    public int getVolunteerIntentContact() {
        return volunteerIntentContact;
    }

    public void setVolunteerIntentContact(int volunteerIntentContact) {
        this.volunteerIntentContact = volunteerIntentContact;
    }

    public int getMemberIntentContact() {
        return memberIntentContact;
    }

    public void setMemberIntentContact(int memberIntentContact) {
        this.memberIntentContact = memberIntentContact;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getBookDistribution() {
        return bookDistribution;
    }

    public void setBookDistribution(int bookDistribution) {
        this.bookDistribution = bookDistribution;
    }

    public boolean isFamilyMeeting() {
        return familyMeeting;
    }

    public void setFamilyMeeting(boolean familyMeeting) {
        this.familyMeeting = familyMeeting;
    }

    public double getSocietyWork() {
        return societyWork;
    }

    public void setSocietyWork(double societyWork) {
        this.societyWork = societyWork;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public boolean isReportKeeping() {
        return reportKeeping;
    }

    public void setReportKeeping(boolean reportKeeping) {
        this.reportKeeping = reportKeeping;
    }

    public boolean isSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(boolean selfAssessment) {
        this.selfAssessment = selfAssessment;
    }
}
