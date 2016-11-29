package com.jolpai.doctorsdiary.Realm_Model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by User on 11/13/2016.
 */

public class DailyReport extends RealmObject implements Serializable,Comparable{
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

    private boolean hasReport;



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

    public boolean isHasReport() {
        return hasReport;
    }

    public void setHasReport(boolean hasReport) {
        this.hasReport = hasReport;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        int compareDate = ((DailyReport)o).getToDay();
        return this.getToDay()-compareDate;
    }
}
