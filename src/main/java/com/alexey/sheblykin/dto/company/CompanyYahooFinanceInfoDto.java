package com.alexey.sheblykin.dto.company;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CompanyYahooFinanceInfoDto implements ICompanyInfoDto {

    private BigDecimal stockPrice;
    private String sector;
    private String industry;
    private List<CompanyYahooFinanceExecutiveDto> keyExecutives;

    public CompanyYahooFinanceInfoDto(BigDecimal stockPrice,
                                      String sector,
                                      String industry,
                                      List<CompanyYahooFinanceExecutiveDto> keyExecutives) {
        this.stockPrice = stockPrice;
        this.sector = sector;
        this.industry = industry;
        this.keyExecutives = keyExecutives;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<CompanyYahooFinanceExecutiveDto> getKeyExecutives() {
        return keyExecutives;
    }

    public void setKeyExecutives(List<CompanyYahooFinanceExecutiveDto> keyExecutives) {
        this.keyExecutives = keyExecutives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyYahooFinanceInfoDto that = (CompanyYahooFinanceInfoDto) o;
        return Objects.equals(getStockPrice(), that.getStockPrice()) && Objects.equals(getSector(), that.getSector()) && Objects.equals(getIndustry(), that.getIndustry()) && Objects.equals(getKeyExecutives(), that.getKeyExecutives());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStockPrice(), getSector(), getIndustry(), getKeyExecutives());
    }
}
