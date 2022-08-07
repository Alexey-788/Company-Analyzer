package com.alexey.sheblykin.dto;

import java.util.Objects;

public class CompanyFullInfoDto {

    private long id;
    private String name;
    private CompanyIndeedInfoDto indeedInfo;
    private CompanyYahooFinanceInfoDto yahooFinanceInfo;

    public CompanyFullInfoDto() {}

    public CompanyFullInfoDto(long id,
                              String name,
                              CompanyIndeedInfoDto indeedInfo,
                              CompanyYahooFinanceInfoDto yahooFinanceInfo) {
        this.id = id;
        this.name = name;
        this.indeedInfo = indeedInfo;
        this.yahooFinanceInfo = yahooFinanceInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyIndeedInfoDto getIndeedInfo() {
        return indeedInfo;
    }

    public void setIndeedInfo(CompanyIndeedInfoDto indeedInfo) {
        this.indeedInfo = indeedInfo;
    }

    public         CompanyYahooFinanceInfoDto getYahooFinanceInfo() {
        return yahooFinanceInfo;
    }

    public void setYahooFinanceInfo(        CompanyYahooFinanceInfoDto yahooFinanceInfo) {
        this.yahooFinanceInfo = yahooFinanceInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyFullInfoDto that = (CompanyFullInfoDto) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getIndeedInfo(), that.getIndeedInfo()) && Objects.equals(getYahooFinanceInfo(), that.getYahooFinanceInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIndeedInfo(), getYahooFinanceInfo());
    }
}
