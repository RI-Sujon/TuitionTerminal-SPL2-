package com.example.tuitionterminal.Tutor;

public class TutorTuitionInfo {
    private String medium, preferredClass , preferredGroup , preferredSubject , daysPerWeekOrMonth , salaryUpto, emailPrimaryKey;

    public TutorTuitionInfo() {
    }

    public TutorTuitionInfo(String medium, String preferredClass, String preferredGroup, String preferredSubject, String daysPerWeekOrMonth, String salaryUpto, String emailPrimaryKey) {
        this.medium = medium;
        this.preferredClass = preferredClass;
        this.preferredGroup = preferredGroup;
        this.preferredSubject = preferredSubject;
        this.daysPerWeekOrMonth = daysPerWeekOrMonth;
        this.salaryUpto = salaryUpto;
        this.emailPrimaryKey = emailPrimaryKey ;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getPreferredClass() {
        return preferredClass;
    }

    public void setPreferredClass(String preferredClass) {
        this.preferredClass = preferredClass;
    }

    public String getPreferredGroup() {
        return preferredGroup;
    }

    public void setPreferredGroup(String preferredGroup) {
        this.preferredGroup = preferredGroup;
    }

    public String getPreferredSubject() {
        return preferredSubject;
    }

    public void setPreferredSubject(String preferredSubject) {
        this.preferredSubject = preferredSubject;
    }

    public String getDaysPerWeekOrMonth() {
        return daysPerWeekOrMonth;
    }

    public void setDaysPerWeekOrMonth(String daysPerWeekOrMonth) {
        this.daysPerWeekOrMonth = daysPerWeekOrMonth;
    }

    public String getSalaryUpto() {
        return salaryUpto;
    }

    public void setSalaryUpto(String salaryUpto) {
        this.salaryUpto = salaryUpto;
    }

    public String getEmailPrimaryKey() {
        return emailPrimaryKey;
    }

    public void setEmailPrimaryKey(String emailPrimaryKey) {
        this.emailPrimaryKey = emailPrimaryKey;
    }

    @Override
    public String toString() {
        return
                "medium='" + medium + '\'' +
                ", preferredClass='" + preferredClass + '\'' +
                ", preferredGroup='" + preferredGroup + '\'' +
                ", preferredSubject='" + preferredSubject + '\'' +
                ", daysPerWeekOrMonth='" + daysPerWeekOrMonth + '\'' +
                ", salaryUpto='" + salaryUpto + '\'' ;
    }
}
