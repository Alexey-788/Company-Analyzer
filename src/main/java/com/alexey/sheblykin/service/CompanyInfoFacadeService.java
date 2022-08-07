package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.CompanyNamesDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Facade for fetching entire {@link CompanyFullInfoDto} from all {@link ICompanyInfoDataService}
 * by names provided by {@link CompanyNamesService}.
 */
@Service
public class CompanyInfoFacadeService {

    private final List<ICompanyInfoDataService<?>> infoDataServices;
    private final CompanyNamesService companyNamesService;

    public CompanyInfoFacadeService(List<ICompanyInfoDataService<?>> infoDataServices, CompanyNamesService companyNamesService) {
        this.infoDataServices = infoDataServices;
        this.companyNamesService = companyNamesService;
    }

    public CompanyFullInfoDto fetchCompanyInfo(long id) throws IOException {
        CompanyNamesDto companyNames = companyNamesService.getById(id);

        CompanyFullInfoDto fullInfoDto = new CompanyFullInfoDto();
        fullInfoDto.setId(id);
        fullInfoDto.setName(companyNames.getIndeedName());

        for (ICompanyInfoDataService<?> dataService : infoDataServices) {
            dataService.uploadTo(fullInfoDto, companyNames);
        }

        return fullInfoDto;
    }
}