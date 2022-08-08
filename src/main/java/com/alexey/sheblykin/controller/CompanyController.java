package com.alexey.sheblykin.controller;

import com.alexey.sheblykin.dto.company.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import com.alexey.sheblykin.service.company.CompanyInfoFacadeDataService;
import com.alexey.sheblykin.service.company.CompanyNamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyNamesService companyNamesService;
    private final CompanyInfoFacadeDataService companyInfoFacadeDataService;

    public CompanyController(CompanyNamesService companyNamesService, CompanyInfoFacadeDataService companyInfoFacadeDataService) {
        this.companyNamesService = companyNamesService;
        this.companyInfoFacadeDataService = companyInfoFacadeDataService;
    }

    /**
     * List of companies' names and ids.
     */
    @GetMapping("/list")
    public ResponseEntity<List<CompanyNamesDto>> namesList() {
        return ResponseEntity.ok(companyNamesService.getAll());
    }

    /**
     * Current company info.
     */
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyFullInfoDto> company(@PathVariable long companyId) throws IOException {
        CompanyFullInfoDto fullInfo = companyInfoFacadeDataService.fetchCompanyInfo(companyId);
        return ResponseEntity.ok(fullInfo);
    }
}
