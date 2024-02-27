package com.prp.business.model.service;

import com.prp.business.model.dao.BusinessDao;
import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.vo.BusinessVo;
import com.prp.business.util.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessDao businessDao;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean createBusiness(BusinessListCreateCommandDto businessListCreateCommandDto) {
        for (BusinessCreateCommandDto business : businessListCreateCommandDto.businessList()) {
            BusinessVo businessVo = BusinessVo.builder()
                    .writerId(businessListCreateCommandDto.writer())
                    .title(business.title())
                    .content(business.content())
                    .build();
            businessDao.insert(businessVo);
        }

        return true;
    }
}
