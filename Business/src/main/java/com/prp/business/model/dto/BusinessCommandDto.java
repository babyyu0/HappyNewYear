package com.prp.business.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

public record BusinessCommandDto(
        @Size(min = 1, max = 50, message = "제목은 1자 이상 50자 이하로 작성해야 합니다.")
        String title,
        @Size(min = 1, max = 2000, message = "내용은 1자 이상 2000자 이하로 작성해야 합니다.")
        String content
) {
    public static BusinessCommandDto from(BusinessRequestDto businessRequestDto) {
        if (businessRequestDto.title().trim().isEmpty() || 50 < businessRequestDto.title().trim().length()) {
            // TO DO :: 예외 처리
        } else if (businessRequestDto.content().trim().isEmpty() || 200 < businessRequestDto.content().trim().length()) {
            // TO DO :: 예외 처리
        }
        return BusinessCommandDto.builder()
                .title(businessRequestDto.title())
                .content(businessRequestDto.content())
                .build();
    }

    @Builder
    public BusinessCommandDto(String title, String content) {
        if (title.trim().isEmpty() || 50 < title.trim().length()) {
            // TO DO :: 예외 처리
        } else if (content.trim().isEmpty() || 200 < content.trim().length()) {
            // TO DO :: 예외 처리
        }
        this.title = title.trim();
        this.content = content.trim();
    }
}
