package com.alexey.sheblykin.service;

import com.alexey.sheblykin.dto.ICompanyInfoDto;

/**
 * Interface for services that loading {@link ICompanyInfoDto} implementations
 * from external resources.
 */
public interface ICompanyInfoDataService<T extends ICompanyInfoDto> {

    T load(String companyName);
}
