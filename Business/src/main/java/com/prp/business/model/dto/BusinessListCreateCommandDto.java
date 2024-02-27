package com.prp.business.model.dto;

import com.prp.business.util.BusinessException;
import com.prp.business.util.ErrorMessage;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public record BusinessListCreateCommandDto(
        String writer,
        List<BusinessCreateCommandDto> businessList
) {
    public static BusinessListCreateCommandDto from(@Valid BusinessListCreateRequestDto businessListCreateRequestDto) {
        if (businessListCreateRequestDto.writer() == null || businessListCreateRequestDto.writer().trim().isEmpty() || 50 < businessListCreateRequestDto.writer().trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        } if (businessListCreateRequestDto.businessList() == null || businessListCreateRequestDto.businessList().isEmpty()) {
            throw new BusinessException(ErrorMessage.BUSINESS_INVALID);
        }

        List<BusinessCreateCommandDto> businessList = new ArrayList<>();
        for (BusinessCreateRequestDto business : businessListCreateRequestDto.businessList()) {
            // 제목 유효성 검사
            if (business.title() == null || business.title().trim().isEmpty() || 50 < business.title().trim().length()) {
                throw new BusinessException(ErrorMessage.TITLE_INVALID);
            } if (business.content() == null || business.content().trim().isEmpty() || 200 < business.content().trim().length()) {
                throw new BusinessException(ErrorMessage.CONTENTS_INVALID);
            }
            businessList.add(BusinessCreateCommandDto.from(business));
        }
        return BusinessListCreateCommandDto.builder()
                .writer(businessListCreateRequestDto.writer().trim())
                .businessList(businessList)
                .build();
    }

    @Builder
    public BusinessListCreateCommandDto(String writer, List<BusinessCreateCommandDto> businessList) {
        if (writer == null || writer.trim().isEmpty() || 50 < writer.trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        } if (businessList == null || businessList.isEmpty()) {
            throw new BusinessException(ErrorMessage.BUSINESS_INVALID);
        }
        this.writer = writer.trim();
        this.businessList = businessList;
    }
}
