package com.alexey.sheblykin.controller;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.service.CompanyInfoFacadeService;
import com.alexey.sheblykin.service.CompanyNamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyNamesService companyNamesService;
    private final CompanyInfoFacadeService companyInfoFacadeService;

    public CompanyController(CompanyNamesService companyNamesService, CompanyInfoFacadeService companyInfoFacadeService) {
        this.companyNamesService = companyNamesService;
        this.companyInfoFacadeService = companyInfoFacadeService;
    }

    /**
     * List of companies' names and ids.
     */
    @GetMapping("/list")
    public ResponseEntity<List<CompanyNamesDto>> namesList() {
        return null;
    }

    /**
     * Current company info.
     */
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyFullInfoDto> company(@PathVariable long companyId) {
        return null;
    }
}
