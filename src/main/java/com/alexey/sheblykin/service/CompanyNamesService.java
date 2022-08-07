package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.entity.CompanyEntity;
import com.alexey.sheblykin.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service works with {@link CompanyRepository}.
 * During reading operation methods receive {@link CompanyEntity} objects
 * and generate {@link CompanyNamesDto} objects.
 * And vice versa during creation operations.
 */
@Service
public class CompanyNamesService {

    private final CompanyRepository companyRepository;

    public CompanyNamesService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyNamesDto getById(long id) {
        return new CompanyNamesDto(companyRepository.getReferenceById(id));
    }

    public List<CompanyNamesDto> getAll() {
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyEntities.stream()
            .map(CompanyNamesDto::new)
            .collect(Collectors.toList());
    }
}
