package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.dto.CompanyYahooFinanceInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CompanyYahooFinanceInfoDataServiceTest {

    String companyName = "AMZN";

    @Autowired
    CompanyYahooFinanceInfoDataService companyYahooFinanceInfoDataService;

    @Test
    void load_LoadingAmazon_ReturnsNotEmptyYahooFinanceInfoFields() throws IOException {
        CompanyNamesDto companyNames = new CompanyNamesDto(0, null, companyName);
        CompanyYahooFinanceInfoDto amazonYahooFinanceInfo = companyYahooFinanceInfoDataService.load(companyNames);

        assertNotNull(amazonYahooFinanceInfo.getStockPrice());
        assertNotEquals(0, amazonYahooFinanceInfo.getStockPrice().intValue());

        assertNotNull(amazonYahooFinanceInfo.getSector());
        assertNotEquals("", amazonYahooFinanceInfo.getSector());

        assertNotNull(amazonYahooFinanceInfo.getIndustry());
        assertNotEquals("", amazonYahooFinanceInfo.getIndustry());

        assertNotNull(amazonYahooFinanceInfo.getKeyExecutives());
        assertNotEquals(0, amazonYahooFinanceInfo.getKeyExecutives().size());
    }
}