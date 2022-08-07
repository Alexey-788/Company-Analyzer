package com.alexey.sheblykin.dto;

import java.util.Objects;

public class CompanyIndeedRatingDto {

    private String caption;
    private String category;
    private String grade;
    private int score;

    public CompanyIndeedRatingDto(String caption, String category, String grade, int score) {
        this.caption = caption;
        this.category = category;
        this.grade = grade;
        this.score = score;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyIndeedRatingDto that = (CompanyIndeedRatingDto) o;
        return getScore() == that.getScore() && Objects.equals(getCaption(), that.getCaption()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getGrade(), that.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCaption(), getCategory(), getGrade(), getScore());
    }
}
