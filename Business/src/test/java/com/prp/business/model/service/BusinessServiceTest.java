package com.prp.business.model.service;

import com.prp.business.model.dao.BusinessDao;
import com.prp.business.model.dto.BusinessCreateCommandDto;
import com.prp.business.model.dto.BusinessListCreateCommandDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void 업무_생성() {
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
        boolean flag = businessService.createBusiness(businessListCreateCommandDto);

        // then
        Assertions.assertTrue(flag, "저장 실패!");
    }
    @Test
    public void 업무_생성_업무가_비었을_때() throws RuntimeException {
        // given
        List<BusinessCreateCommandDto> businessList = new ArrayList<>();
        BusinessListCreateCommandDto businessListCreateCommandDto = BusinessListCreateCommandDto.builder()
                .writer("작성자 Test")
                .businessList(businessList)
                .build();

        // when
        boolean flag = businessService.createBusiness(businessListCreateCommandDto);

        // then
        Assertions.assertTrue(flag, "저장 실패!");
    }
    @Test
    public void 업무_생성_작성자가_비었을_때() throws RuntimeException {
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
                .writer(null)
                .businessList(businessList)
                .build();

        // when
        boolean flag = businessService.createBusiness(businessListCreateCommandDto);

        // then
        Assertions.assertTrue(flag, "저장 실패!");
    }
}
