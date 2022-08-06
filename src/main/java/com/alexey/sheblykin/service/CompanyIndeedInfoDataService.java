package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyIndeedInfoDto;
import org.springframework.stereotype.Service;

/**
 * Service that load {@link CompanyIndeedInfoDto} from http://indeed.com
 */
@Service
public class CompanyIndeedInfoDataService implements ICompanyInfoDataService<CompanyIndeedInfoDto> {

    @Override
    public CompanyIndeedInfoDto load(String companyName) {
        return null;
    }
}
