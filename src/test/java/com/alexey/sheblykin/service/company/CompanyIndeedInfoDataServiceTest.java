package com.alexey.sheblykin.service.company;

import com.alexey.sheblykin.dto.company.CompanyIndeedInfoDto;
import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import com.alexey.sheblykin.service.company.CompanyIndeedInfoDataService;
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
class CompanyIndeedInfoDataServiceTest {

    String companyName = "Amazon.com";

    @Autowired
    CompanyIndeedInfoDataService companyIndeedInfoDataService;

    @Test
    void load_LoadingAmazon_ReturnsNotEmptyIndeedInfoFields() throws IOException {
        CompanyNamesDto companyNames = new CompanyNamesDto(0, companyName, null);
        CompanyIndeedInfoDto amazonIndeedInfo = companyIndeedInfoDataService.load(companyNames);

        assertNotNull(amazonIndeedInfo.getDescription());
        assertNotEquals("", amazonIndeedInfo.getDescription());

        assertNotNull(amazonIndeedInfo.getSalaries());
        assertNotEquals("", amazonIndeedInfo.getSalaries());

        assertNotNull(amazonIndeedInfo.getRatings());
        assertNotEquals(0, amazonIndeedInfo.getRatings().size());
    }
}