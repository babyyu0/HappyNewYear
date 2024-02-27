package com.prp.business.model.service;

import com.prp.business.model.dao.BusinessDao;
import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.dto.BusinessListReadResponseDto;
import com.prp.business.model.dto.BusinessReadResponseDto;
import com.prp.business.model.vo.BusinessVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessDao businessDao;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean setBusinessList(BusinessListCreateCommandDto businessListCreateCommandDto) {
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

    @Override
    @Transactional(readOnly = true)
    public List<BusinessListReadResponseDto> getBusinessList() {
        List<BusinessVo> businessList = businessDao.selectAll();
        List<BusinessListReadResponseDto> businessDtoList = new ArrayList<>();

        for (BusinessVo business : businessList) {
            businessDtoList.add(BusinessListReadResponseDto.from(business));
        }

        return businessDtoList;
    }
}
