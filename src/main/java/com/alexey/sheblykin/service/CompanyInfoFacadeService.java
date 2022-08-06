package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Facade for fetching entire {@link CompanyFullInfoDto} from all {@link ICompanyInfoDataService}
 * by names provided by {@link CompanyNamesService}.
 */
@Service
public class CompanyInfoFacadeService {

    List<ICompanyInfoDataService<?>> infoDataServices;
    CompanyNamesService companyNamesService;

    public CompanyInfoFacadeService(List<ICompanyInfoDataService<?>> infoDataServices, CompanyNamesService companyNamesService) {
        this.infoDataServices = infoDataServices;
        this.companyNamesService = companyNamesService;
    }

    public CompanyFullInfoDto fetchCompanyInfo(long id) {
        return null;
    }
}