package com.prp.business.model.service;

import com.prp.business.model.dao.BusinessDao;
import com.prp.business.model.dto.BusinessCommandDto;
import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.vo.BusinessVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessDao businessDao;

    @Override
    @Transactional
    public boolean createBusiness(BusinessCreateCommandDto businessCreateCommandDto) {
        for (BusinessCommandDto business : businessCreateCommandDto.businessList()) {
            BusinessVo businessVo = BusinessVo.builder()
                    .writerId(businessCreateCommandDto.writer())
                    .title(business.title())
                    .content(business.content())
                    .build();
            businessDao.insert(businessVo);
        }

        return true;
    }
}
