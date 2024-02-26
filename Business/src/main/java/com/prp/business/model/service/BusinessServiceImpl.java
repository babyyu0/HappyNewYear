package com.prp.business.model.service;

import com.prp.business.model.dto.BusinessCreateCommandDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Override
    @Transactional
    public void createBusiness(BusinessCreateCommandDto businessCreateCommandDto) {
        
    }
}
