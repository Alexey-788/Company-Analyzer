package com.alexey.sheblykin.service.company;

import com.alexey.sheblykin.dto.company.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import com.alexey.sheblykin.service.company.CompanyInfoFacadeDataService;
import com.alexey.sheblykin.service.company.CompanyNamesService;
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
class CompanyInfoFacadeDataServiceTest {

    @MockBean
    CompanyNamesService companyNamesService;

    @Autowired
    CompanyInfoFacadeDataService companyInfoFacadeDataService;

    @Test
    void fetchCompanyInfo_FetchingAmazonInfo_LoadsFields() throws IOException {
        when(companyNamesService.getById(0))
                .thenReturn(new CompanyNamesDto(0, "Amazon.com", "AMZN"));

        CompanyFullInfoDto companyInfo = companyInfoFacadeDataService.fetchCompanyInfo(0);

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