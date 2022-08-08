package com.alexey.sheblykin.dto.company;

import java.util.List;
import java.util.Objects;

public class CompanyIndeedInfoDto implements ICompanyInfoDto {

    private String description;
    private String salaries;
    private List<CompanyIndeedRatingDto> ratings;

    public CompanyIndeedInfoDto(String description, String salaries, List<CompanyIndeedRatingDto> ratings) {
        this.description = description;
        this.salaries = salaries;
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaries() {
        return salaries;
    }

    public void setSalaries(String salaries) {
        this.salaries = salaries;
    }

    public List<CompanyIndeedRatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<CompanyIndeedRatingDto> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyIndeedInfoDto that = (CompanyIndeedInfoDto) o;
        return Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getSalaries(), that.getSalaries()) && Objects.equals(getRatings(), that.getRatings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getSalaries(), getRatings());
    }
}
