package com.prp.business.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record BusinessCreateRequestDto(
        @Size(min=1, max=50, message = "업무자는 1자 이상 50자 이하로 작성해야 합니다.")
        String writer,
        @Valid
        @NotEmpty(message = "업무가 1개 이상 포함되어야 합니다.")
        List<BusinessRequestDto> businessList
) {
}
