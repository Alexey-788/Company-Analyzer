package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.CompanyNamesDto;
import com.alexey.sheblykin.entity.CompanyEntity;
import com.alexey.sheblykin.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service works with {@link CompanyRepository}.
 * During reading operation methods receive {@link CompanyEntity} objects
 * and generate {@link CompanyNamesDto} objects.
 * And vice versa during creation operations.
 */
@Service
public class CompanyNamesService {

    public CompanyNamesDto getById(long id) {
        return null;
    }

    public List<CompanyNamesDto> getAll() {
        return null;
    }
}
