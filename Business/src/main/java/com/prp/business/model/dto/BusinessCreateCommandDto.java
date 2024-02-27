package com.prp.business.model.dto;

import jakarta.validation.Valid;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public record BusinessCreateCommandDto(
        String writer,
        List<BusinessCommandDto> businessList
) {
    public static BusinessCreateCommandDto from(@Valid BusinessCreateRequestDto businessCreateRequestDto) {
        if (businessCreateRequestDto.writer().trim().isEmpty() || 50 < businessCreateRequestDto.writer().trim().length()) {
            // TO DO :: 예외 처리
        }

        List<BusinessCommandDto> businessList = new ArrayList<>();
        for (BusinessRequestDto business : businessCreateRequestDto.businessList()) {
            // 제목 유효성 검사
            if (business.title().trim().isEmpty() || 50 < business.title().trim().length()) {
                // TO DO :: 예외 처리
            } else if (business.content().trim().isEmpty() || 200 < business.content().trim().length()) {
                // TO DO :: 예외 처리
            }
            businessList.add(BusinessCommandDto.from(business));
        }
        return BusinessCreateCommandDto.builder()
                .writer(businessCreateRequestDto.writer().trim())
                .businessList(businessList)
                .build();
    }

    @Builder
    public BusinessCreateCommandDto(String writer, List<BusinessCommandDto> businessList) {
        if (writer.trim().isEmpty() || 50 < writer.trim().length()) {
            // TO DO :: 예외 처리
        } else if (businessList.isEmpty()) {
            // TO DO :: 예외 처리
        }
        this.writer = writer.trim();
        this.businessList = businessList;
    }
}
