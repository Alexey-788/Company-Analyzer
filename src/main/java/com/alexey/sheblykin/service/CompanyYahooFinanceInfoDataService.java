package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.dto.CompanyYahooFinanceExecutiveDto;
import com.alexey.sheblykin.dto.CompanyYahooFinanceInfoDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that load {@link CompanyYahooFinanceInfoDto} from http://finance.yahoo.com
 */
@Service
public class CompanyYahooFinanceInfoDataService implements ICompanyInfoDataService<CompanyYahooFinanceInfoDto> {

    @Override
    public CompanyYahooFinanceInfoDto load(CompanyNamesDto companyNames) throws IOException {
        String profileUrl = "https://finance.yahoo.com/quote/" + companyNames.getYahooFinanceName() + "/profile";
        Document profileDocument = Jsoup.connect(profileUrl).get();

        String sector = "";
        String industry = "";
        List<CompanyYahooFinanceExecutiveDto> keyExecutives = new ArrayList<>();

        String stringPrice = profileDocument.select("#quote-header-info [data-field=regularMarketPrice]").text();
        stringPrice = stringPrice.replace(",", "");

        BigDecimal price = new BigDecimal(stringPrice);

        Element profileContainer = profileDocument.selectFirst(".asset-profile-container");

        if (profileContainer != null) {
            sector = profileContainer.select("span:nth-child(2)").text();
            industry = profileContainer.select("span:nth-child(5)").text();
        }

        Elements executiveRows = profileDocument.select(".quote-subsection table tbody tr");

        for (Element executiveRow : executiveRows) {
            String name = executiveRow.select(" td:nth-child(1)").text();
            String title = executiveRow.select(" td:nth-child(2)").text();
            String pay = executiveRow.select(" td:nth-child(3)").text();
            String exercised = executiveRow.select(" td:nth-child(4)").text();
            String yearBorn = executiveRow.select(" td:nth-child(5)").text();

            keyExecutives.add(new CompanyYahooFinanceExecutiveDto(name, title, pay, exercised, yearBorn));
        }

        return new CompanyYahooFinanceInfoDto(price, sector, industry, keyExecutives);
    }

    @Override
    public void uploadTo(CompanyFullInfoDto fullInfoDto, CompanyNamesDto companyNames) throws IOException {
        fullInfoDto.setYahooFinanceInfo(load(companyNames));
    }
}
