package com.alexey.sheblykin.dto.company;

import com.alexey.sheblykin.entity.CompanyEntity;

import java.util.Objects;

public class CompanyNamesDto {

    private long id;
    private String indeedName;
    private String yahooFinanceName;

    public CompanyNamesDto(long id, String indeedName, String yahooFinanceName) {
        this.id = id;
        this.indeedName = indeedName;
        this.yahooFinanceName = yahooFinanceName;
    }

    public CompanyNamesDto(CompanyEntity companyEntity) {
        this.id = companyEntity.getId();
        this.indeedName = companyEntity.getIndeedName();
        this.yahooFinanceName = companyEntity.getYahooFinanceName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIndeedName() {
        return indeedName;
    }

    public void setIndeedName(String indeedName) {
        this.indeedName = indeedName;
    }

    public String getYahooFinanceName() {
        return yahooFinanceName;
    }

    public void setYahooFinanceName(String yahooFinanceName) {
        this.yahooFinanceName = yahooFinanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyNamesDto that = (CompanyNamesDto) o;
        return getId() == that.getId() && Objects.equals(getIndeedName(), that.getIndeedName()) && Objects.equals(getYahooFinanceName(), that.getYahooFinanceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIndeedName(), getYahooFinanceName());
    }
}
