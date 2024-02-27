package com.prp.business.model.service;

import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.dto.BusinessListReadResponseDto;

import java.util.List;

public interface BusinessService {
    boolean setBusinessList(BusinessListCreateCommandDto businessListCreateCommandDto);
    List<BusinessListReadResponseDto> getBusinessList();
}
