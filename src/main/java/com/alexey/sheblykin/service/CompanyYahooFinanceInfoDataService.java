package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyYahooFinanceInfoDto;
import org.springframework.stereotype.Service;

/**
 * Service that load {@link CompanyYahooFinanceInfoDto} from http://finance.yahoo.com
 */
@Service
public class CompanyYahooFinanceInfoDataService implements ICompanyInfoDataService<CompanyYahooFinanceInfoDto> {

    @Override
    public CompanyYahooFinanceInfoDto load(String companyName) {
        return null;
    }
}
