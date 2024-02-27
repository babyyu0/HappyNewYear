package com.prp.business.model.dto;

import jakarta.validation.constraints.Size;

public record BusinessCreateRequestDto(
        @Size(min = 1, max = 50, message = "제목은 1자 이상 50자 이하로 작성해야 합니다.")
        String title,
        @Size(min = 1, max = 2000, message = "내용은 1자 이상 2000자 이하로 작성해야 합니다.")
        String content
) {
}
