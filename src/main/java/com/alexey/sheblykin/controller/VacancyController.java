package com.alexey.sheblykin.controller;

import com.alexey.sheblykin.dto.VacancyIndeedInfoDto;
import com.alexey.sheblykin.service.VacancyDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private final VacancyDataService vacancyDataService;

    public VacancyController(VacancyDataService vacancyDataService) {
        this.vacancyDataService = vacancyDataService;
    }

    /**
     * Vacancy list page of company with specified id.
     */
    @GetMapping("/page/{page}/company/{companyId}")
    public ResponseEntity<List<VacancyIndeedInfoDto>> vacancyListOfCompany(
            @PathVariable int page,
            @PathVariable long companyId
    ) throws IOException {
        List<VacancyIndeedInfoDto> baseInfoList = vacancyDataService.loadCompanyVacancies(page, companyId);
        return ResponseEntity.ok(baseInfoList);
    }
}
