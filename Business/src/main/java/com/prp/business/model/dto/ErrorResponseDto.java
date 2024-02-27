package com.prp.business.model.dto;

public record ErrorResponseDto(
        String code,
        String message
) {
}
