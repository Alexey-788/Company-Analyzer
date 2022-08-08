package com.alexey.sheblykin.dto;

import java.util.Objects;

public class VacancyIndeedInfoDto {

    private String id;
    private String title;
    private String location;
    private String salary;
    private String date;

    public VacancyIndeedInfoDto() {
    }

    public VacancyIndeedInfoDto(String id, String title, String location, String salary, String date) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.salary = salary;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacancyIndeedInfoDto that = (VacancyIndeedInfoDto) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getSalary(), that.getSalary()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLocation(), getSalary(), getDate());
    }
}
