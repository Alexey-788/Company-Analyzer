package com.alexey.sheblykin.controller;

import com.alexey.sheblykin.dto.company.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import com.alexey.sheblykin.service.company.CompanyInfoFacadeDataService;
import com.alexey.sheblykin.service.company.CompanyNamesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CompanyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CompanyNamesService companyNamesService;

    @MockBean
    CompanyInfoFacadeDataService companyInfoFacadeDataService;

    @Test
    void namesList_WithThreeNames_ReturnsRightNames() throws Exception {
        CompanyNamesDto names1 = new CompanyNamesDto(1, "Indeed1", "YahooFinance1");
        CompanyNamesDto names2 = new CompanyNamesDto(2, "Indeed2", "YahooFinance2");
        CompanyNamesDto names3 = new CompanyNamesDto(3, "Indeed3", "YahooFinance3");

        when(companyNamesService.getAll())
                .thenReturn(List.of(names1, names2, names3));

        mockMvc.perform(get("/company/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(3));
    }

    @Test
    void namesList_WithEmptyNamesList_ReturnEmptyJson() throws Exception {
        when(companyNamesService.getAll()).thenReturn(List.of());

        mockMvc.perform(get("/company/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void company_WithExistingCompany_ReturnRightCompany() throws Exception {
        CompanyFullInfoDto companyInfo = new CompanyFullInfoDto(3, "Company", null, null);

        when(companyInfoFacadeDataService.fetchCompanyInfo(3)).thenReturn(companyInfo);

        mockMvc.perform(get("/company/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Company"));
    }

    @Test
    void company_WithNonExistingCompany_ReturnNotFound() throws Exception {
        when(companyInfoFacadeDataService.fetchCompanyInfo(0)).thenThrow(new EntityNotFoundException());

        mockMvc.perform(get("/company/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void company_WithNegativeCompanyId_ReturnNotFound() throws Exception {
        when(companyInfoFacadeDataService.fetchCompanyInfo(-1)).thenThrow(new EntityNotFoundException());

        mockMvc.perform(get("/company/-1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}