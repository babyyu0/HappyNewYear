package com.prp.business.model.service;

import com.prp.business.model.dto.BusinessCreateCommandDto;

public interface BusinessService {
    void createBusiness(BusinessCreateCommandDto businessCreateCommandDto);
}
