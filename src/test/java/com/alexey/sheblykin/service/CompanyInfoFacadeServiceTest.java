package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.CompanyNamesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CompanyInfoFacadeServiceTest {

    @MockBean
    CompanyNamesService companyNamesService;

    @Autowired
    CompanyInfoFacadeService companyInfoFacadeService;

    @Test
    void fetchCompanyInfo_FetchingAmazonInfo_LoadsFields() throws IOException {
        when(companyNamesService.getById(0))
                .thenReturn(new CompanyNamesDto(0, "Amazon.com", "AMZN"));

        CompanyFullInfoDto companyInfo = companyInfoFacadeService.fetchCompanyInfo(0);

        assertEquals(0, companyInfo.getId());
        assertEquals("Amazon.com", companyInfo.getName());

        assertNotNull(companyInfo.getIndeedInfo());
        assertNotNull(companyInfo.getYahooFinanceInfo());

        assertNotNull(companyInfo.getIndeedInfo().getDescription());
        assertNotEquals("", companyInfo.getIndeedInfo().getDescription());

        assertNotNull(companyInfo.getYahooFinanceInfo().getIndustry());
        assertNotEquals("", companyInfo.getYahooFinanceInfo().getIndustry());
    }
}