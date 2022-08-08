package com.alexey.sheblykin.service.company;

import com.alexey.sheblykin.dto.company.CompanyNamesDto;
import com.alexey.sheblykin.entity.CompanyEntity;
import com.alexey.sheblykin.repository.CompanyRepository;
import com.alexey.sheblykin.service.company.CompanyNamesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CompanyNamesServiceTest {

    @MockBean
    CompanyRepository companyRepository;

    @Autowired
    CompanyNamesService companyNamesService;

    @Test
    void getById_WithExistingCompany_ReturnsRightCompany() {
        CompanyEntity companyEntity = new CompanyEntity(0L, "Indeed", "YahooFinance");

        when(companyRepository.getReferenceById(0L)).thenReturn(companyEntity);

        assertThat(companyNamesService.getById(0))
                .isEqualTo(new CompanyNamesDto(companyEntity));
    }

    @Test()
    void getById_WithNonExistingCompany_ThrowsEntityNotFoundException() {
        when(companyRepository.getReferenceById(0L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class,
                () -> companyNamesService.getById(0L));
    }

    @Test()
    void getById_WithNegativeCompanyId_ThrowsEntityNotFoundException() {
        when(companyRepository.getReferenceById(-1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class,
                () -> companyNamesService.getById(-1L));
    }

    @Test
    void getAll_WithThreeCompany_ReturnsRightCompanies() {
        CompanyEntity companyEntity1 = new CompanyEntity(1, "Indeed1", "YahooFinance1");
        CompanyEntity companyEntity2 = new CompanyEntity(2, "Indeed2", "YahooFinance2");
        CompanyEntity companyEntity3 = new CompanyEntity(3, "Indeed3", "YahooFinance3");

        List<CompanyEntity> actualEntities = List.of(companyEntity1, companyEntity2, companyEntity3);
        List<CompanyNamesDto> expectedDTOs = List.of(
                new CompanyNamesDto(companyEntity1),
                new CompanyNamesDto(companyEntity2),
                new CompanyNamesDto(companyEntity3)
        );

        when(companyRepository.findAll())
                .thenReturn(actualEntities);

        assertIterableEquals(companyNamesService.getAll(), expectedDTOs);
    }

    @Test
    void getAll_WithNonCompany_ReturnsEmptyList() {
        when(companyRepository.findAll())
                .thenReturn(List.of());

        assertIterableEquals(companyNamesService.getAll(), List.of());
    }
}