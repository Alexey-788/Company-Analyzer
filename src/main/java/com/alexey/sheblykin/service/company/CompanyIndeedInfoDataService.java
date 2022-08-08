package com.alexey.sheblykin.service.company;

import com.alexey.sheblykin.dto.company.CompanyFullInfoDto;
import com.alexey.sheblykin.dto.company.CompanyIndeedInfoDto;
import com.alexey.sheblykin.dto.company.CompanyIndeedRatingDto;
import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that load {@link CompanyIndeedInfoDto} from http://indeed.com
 */
@Service
public class CompanyIndeedInfoDataService implements ICompanyInfoDataService<CompanyIndeedInfoDto> {

    @Override
    public CompanyIndeedInfoDto load(CompanyNamesDto companyNames) throws IOException {
        String url = "https://www.indeed.com/cmp/" + companyNames.getIndeedName();

        String salaries;
        String description;
        List<CompanyIndeedRatingDto> ratings = new ArrayList<>();

        Document document = Jsoup.connect(url).ignoreContentType(false).get();

        salaries = document.select("[data-tn-section=salary-section] p").text();

        String initData = document.select("#comp-initialData").html();
        JSONObject jsonData = (JSONObject) JSONValue.parse(initData);

        JSONObject aboutSectionViewModel = (JSONObject) jsonData.get("aboutSectionViewModel");
        JSONObject aboutCompany = (JSONObject) aboutSectionViewModel.get("aboutCompany");

        description = (String) aboutCompany.get("description");

        JSONObject happinessModule = (JSONObject) jsonData.get("happinessModule");
        JSONArray individualRatings = (JSONArray) happinessModule.get("individualRatings");

        for (Object rating : individualRatings) {
            JSONObject individualRating = (JSONObject) rating;
            String caption = (String) individualRating.get("caption");
            String category = (String) individualRating.get("category");
            String grade = (String) individualRating.get("grade");
            int score = ((Long) individualRating.get("score")).intValue();

            ratings.add(new CompanyIndeedRatingDto(caption, category, grade, score));
        }

        return new CompanyIndeedInfoDto(description, salaries, ratings);
    }

    @Override
    public void uploadTo(CompanyFullInfoDto fullInfoDto, CompanyNamesDto companyNames) throws IOException {
        fullInfoDto.setIndeedInfo(load(companyNames));
    }
}
