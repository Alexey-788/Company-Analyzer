package com.alexey.sheblykin.controller;

import com.alexey.sheblykin.dto.VacancyIndeedInfoDto;
import com.alexey.sheblykin.service.VacancyDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class VacancyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VacancyDataService vacancyDataService;

    @Test
    void vacancyListOfCompany_WithThreeVacancies_ReturnsRightVacancies() throws Exception {
        List<VacancyIndeedInfoDto> baseInfoList = List.of(
                new VacancyIndeedInfoDto("0", "Title1", "Location1", "Salary1", "Date1"),
                new VacancyIndeedInfoDto("1", "Title2", "Location2", "Salary2", "Date2"),
                new VacancyIndeedInfoDto("2", "Title3", "Location3", "Salary3", "Date3")
        );

        when(vacancyDataService.loadCompanyVacancies(0, 0))
                .thenReturn(baseInfoList);

        mockMvc.perform(get("/vacancy/page/0/company/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[1].title").value("Title2"))
                .andExpect(jsonPath("$[2].title").value("Title3"));
    }

    @Test
    void vacancyListOfCompany_WithEmptyVacancyList_ReturnsEmptyJson() throws Exception {
        List<VacancyIndeedInfoDto> baseInfoList = List.of();

        when(vacancyDataService.loadCompanyVacancies(0, 0))
                .thenReturn(baseInfoList);

        mockMvc.perform(get("/vacancy/page/0/company/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}