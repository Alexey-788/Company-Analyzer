package com.alexey.sheblykin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_gen")
    @SequenceGenerator(name = "company_id_gen", sequenceName = "company_id_seq")
    private long id;

    private String indeedName;
    private String yahooFinanceName;

    public CompanyEntity() {
    }

    public CompanyEntity(long id, String indeedName, String yahooFinanceName) {
        this.id = id;
        this.indeedName = indeedName;
        this.yahooFinanceName = yahooFinanceName;
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
        CompanyEntity that = (CompanyEntity) o;
        return getId() == that.getId() && Objects.equals(getIndeedName(), that.getIndeedName()) && Objects.equals(getYahooFinanceName(), that.getYahooFinanceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIndeedName(), getYahooFinanceName());
    }
}
