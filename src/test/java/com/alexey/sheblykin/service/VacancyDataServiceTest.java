package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.dto.VacancyIndeedInfoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application.yml")
class VacancyDataServiceTest {

    @Autowired
    VacancyDataService vacancyDataService;

    @Value("${vacancy.page.size}")
    int pageSize;

    @MockBean
    CompanyNamesService companyNamesService;

    final int companyId = 0;

    @BeforeEach
    void beforeEach() {
        when(companyNamesService.getById(companyId))
                .thenReturn(new CompanyNamesDto(0, "Amazon.com", null));
    }

    @Test
    void loadCompanyVacancies_LoadingAmazonVacancies_ReturnRightPageSize() throws IOException {
        List<VacancyIndeedInfoDto> pageVacancies = vacancyDataService.loadCompanyVacancies(0, companyId);

        assertEquals(pageSize, pageVacancies.size());
    }

    @Test
    void loadCompanyVacancies_LoadingAmazonVacancies_ReturnsListWithNotEmptyFieldsOfItems() throws IOException {
        List<VacancyIndeedInfoDto> pageVacancies = vacancyDataService.loadCompanyVacancies(0, companyId);

        for (VacancyIndeedInfoDto baseInfo : pageVacancies) {

            assertNotNull(baseInfo.getId());
            assertNotEquals("", baseInfo.getId());

            assertNotNull(baseInfo.getTitle());
            assertNotEquals("", baseInfo.getTitle());

            assertNotNull(baseInfo.getLocation());
            assertNotEquals("", baseInfo.getLocation());

            assertNotNull(baseInfo.getSalary());
            assertNotEquals("", baseInfo.getSalary());

            assertNotNull(baseInfo.getDate());
            assertNotEquals("", baseInfo.getDate());
        }
    }

    @Test
    void loadCompanyVacancies_LoadingAmazonVacancies_ContentOfDifferentPagesDiffers() throws IOException {
        List<VacancyIndeedInfoDto> firstPageVacancies = vacancyDataService.loadCompanyVacancies(0, companyId);
        List<VacancyIndeedInfoDto> secondPageVacancies = vacancyDataService.loadCompanyVacancies(1, companyId);

        assertNotEquals(firstPageVacancies, secondPageVacancies);
    }
}