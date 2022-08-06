package com.alexey.sheblykin.dto;

import java.util.Objects;

public class CompanyYahooFinanceExecutiveDto {

    private String name;
    private String title;
    private String pay;
    private String exercised;
    private String yearBorn;

    public CompanyYahooFinanceExecutiveDto(String name, String title, String pay, String exercised, String yearBorn) {
        this.name = name;
        this.title = title;
        this.pay = pay;
        this.exercised = exercised;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getExercised() {
        return exercised;
    }

    public void setExercised(String exercised) {
        this.exercised = exercised;
    }

    public String getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(String yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyYahooFinanceExecutiveDto that = (CompanyYahooFinanceExecutiveDto) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getPay(), that.getPay()) && Objects.equals(getExercised(), that.getExercised()) && Objects.equals(getYearBorn(), that.getYearBorn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTitle(), getPay(), getExercised(), getYearBorn());
    }
}
