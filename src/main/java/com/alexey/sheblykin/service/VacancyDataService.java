package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.VacancyIndeedInfoDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacancyDataService {

    @Autowired
    private CompanyNamesService companyNamesService;

    @Value("${vacancy.page.size}")
    private int pageSize;

    /**
     * ulrPageSize shows after overcoming what number Indeed flows the vacancy page.
     * With a real number of vacancies has nothing to do, because caused by the bag on Indeed.
     */
    @Value("${vacancy.page.sizeInUrl}")
    private int urlPageSize;

    public VacancyDataService(CompanyNamesService companyNamesService) {
        this.companyNamesService = companyNamesService;
    }

    public List<VacancyIndeedInfoDto> loadCompanyVacancies(int page, long companyId) throws IOException {
        String companyName = companyNamesService.getById(companyId).getIndeedName();

        int startWith = page * urlPageSize;
        String jobsUrl = "https://www.indeed.com/cmp/" + companyName + "/jobs?start=" + startWith;

        Document jobsPage = Jsoup.connect(jobsUrl).get();
        Elements jobItems = jobsPage.select("[data-testid=jobListItem]");

        List<VacancyIndeedInfoDto> vacancyInfoList = new ArrayList<>();
        for (Element jobItem : jobItems) {
            String id = jobItem.attr("data-tn-entityid");
            id = id.substring(2, 18);
            String title = jobItem.select("[data-testid=jobListItem-title]").text();
            String location = jobItem.select("[data-testid=jobListItem-location]").text();
            String salary = jobItem.select("[data-testid=jobListItem-salary]").text();
            String date = jobItem.select("[data-testid=jobListItem-date]").text();

            String defaultValue = "Not specified";
            if (salary.equals("")) salary = defaultValue;

            VacancyIndeedInfoDto baseInfo = new VacancyIndeedInfoDto(id, title, location, salary, date);

            vacancyInfoList.add(baseInfo);
        }
        return vacancyInfoList;
    }
}
