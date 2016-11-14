package com.jolpai.doctorsdiary.realm_model;

import io.realm.RealmObject;

/**
 * Created by User on 11/13/2016.
 */

public class DailyReport extends RealmObject {
    private int date;
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
    private float societyWork;
    private boolean visit;
    private boolean reportKeeping;
    private boolean selfAssessment;



    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public float getSocietyWork() {
        return societyWork;
    }

    public void setSocietyWork(float societyWork) {
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
