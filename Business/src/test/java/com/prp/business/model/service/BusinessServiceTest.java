package com.prp.business.model.service;

import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateCommandDto;
import com.prp.business.model.dto.BusinessListReadResponseDto;
import com.prp.business.util.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BusinessServiceTest {
    private final BusinessService businessService;

    @Autowired
    public BusinessServiceTest(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Test
    @DisplayName("업무 생성")
    @Transactional
    public void setBusinessList() {
        // given
        List<BusinessCreateCommandDto> businessList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            businessList.add(BusinessCreateCommandDto.builder()
                    .title("제목 Test")
                    .content("내용 Test... 내용 Test... 내용 Test...")
                    .build()
            );
        }
        BusinessListCreateCommandDto businessListCreateCommandDto = BusinessListCreateCommandDto.builder()
                .writer("작성자 Test")
                .businessList(businessList)
                .build();

        // when
        boolean flag = businessService.setBusinessList(businessListCreateCommandDto);

        // then
        Assertions.assertTrue(flag, "저장 실패!");
    }
    @Test
    @DisplayName("업무 조회")
    @Transactional
    public void getBusinessList() {
        // given

        // when
        List<BusinessListReadResponseDto> businessDtoList = businessService.getBusinessList();

        // then
        Assertions.assertNotEquals(null, businessDtoList);
        Assertions.assertNotEquals(0, businessDtoList.size());
    }
}
