package com.prp.business.model.dto;

import com.prp.business.util.BusinessException;
import com.prp.business.util.ErrorMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public record BusinessCreateCommandDto(
        @Size(min = 1, max = 50, message = "제목은 1자 이상 50자 이하로 작성해야 합니다.")
        String title,
        @Size(min = 1, max = 2000, message = "내용은 1자 이상 2000자 이하로 작성해야 합니다.")
        String content
) {
    public static BusinessCreateCommandDto from(@Valid BusinessCreateRequestDto businessRequestDto) {
        if (businessRequestDto.title() == null || businessRequestDto.title().trim().isEmpty() || 50 < businessRequestDto.title().trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        } else if (businessRequestDto.content() == null || businessRequestDto.content().trim().isEmpty() || 200 < businessRequestDto.content().trim().length()) {
            throw new BusinessException(ErrorMessage.CONTENTS_INVALID);
        }
        return BusinessCreateCommandDto.builder()
                .title(businessRequestDto.title())
                .content(businessRequestDto.content())
                .build();
    }

    @Builder
    public BusinessCreateCommandDto(String title, String content) {
        if (title == null || title.trim().isEmpty() || 50 < title.trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        } else if (content == null || content.trim().isEmpty() || 200 < content.trim().length()) {
            throw new BusinessException(ErrorMessage.CONTENTS_INVALID);
        }
        this.title = title.trim();
        this.content = content.trim();
    }
}
