package com.prp.business.model.service;

import com.prp.business.model.dto.BusinessListCreateCommandDto;

public interface BusinessService {
    boolean createBusiness(BusinessListCreateCommandDto businessListCreateCommandDto);
}
