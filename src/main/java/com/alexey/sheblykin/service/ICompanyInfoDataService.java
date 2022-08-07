package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.dto.ICompanyInfoDto;

import java.io.IOException;

/**
 * Interface for services that loading {@link ICompanyInfoDto} implementations
 * from external resources.
 */
public interface ICompanyInfoDataService<T extends ICompanyInfoDto> {


    /**
     * Load {@link ICompanyInfoDto} implementation using name from provided {@link CompanyNamesDto}.
     */
    T load(CompanyNamesDto companyNames) throws IOException;

    /**
     * Upload data from external service to provided {@link CompanyFullInfoDto}
     * using {@link CompanyNamesDto}.
     */
    void uploadTo(CompanyFullInfoDto fullInfoDto, CompanyNamesDto companyNames) throws IOException;
}
