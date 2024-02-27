package com.prp.business.model.dto;

import com.prp.business.model.vo.BusinessVo;
import com.prp.business.util.BusinessException;
import com.prp.business.util.ErrorMessage;
import com.prp.business.util.RegexPattern;
import lombok.AccessLevel;
import lombok.Builder;

import java.sql.Timestamp;
import java.util.regex.Pattern;

public record BusinessListReadResponseDto(
        String id,
        String writer,
        String title,
        Timestamp createdDate,
        Timestamp updatedDate,
        Timestamp deletedDate
) {

    public static BusinessListReadResponseDto from(BusinessVo business) {
        if (business.getId() == null || !Pattern.matches(RegexPattern.bizId, business.getId())) {
            throw new BusinessException(ErrorMessage.ID_INVALID);
        }
        if (business.getWriterId() == null || business.getWriterId().trim().isEmpty() || 50 < business.getWriterId().trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        }
        if (business.getTitle() == null || business.getTitle().trim().isEmpty() || 50 < business.getTitle().trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        }
        if (business.getCreatedDate() == null) {
            throw new BusinessException(ErrorMessage.CREATED_DATE_INVALID);
        }
        if (business.getUpdatedDate() == null) {
            throw new BusinessException(ErrorMessage.UPDATED_DATE_INVALID);
        }

        return BusinessListReadResponseDto.builder()
                .id(business.getId())
                .writer(business.getWriterId())
                .title(business.getTitle())
                .createdDate(business.getCreatedDate())
                .updatedDate(business.getUpdatedDate())
                .deletedDate(business.getDeletedDate())
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    public BusinessListReadResponseDto(String id, String writer, String title, Timestamp createdDate, Timestamp updatedDate, Timestamp deletedDate) {
        if (id == null || !Pattern.matches(RegexPattern.bizId, id)) {
            throw new BusinessException(ErrorMessage.ID_INVALID);
        }
        if (writer == null || writer.trim().isEmpty() || 50 < writer.trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        }
        if (title == null || title.trim().isEmpty() || 50 < title.trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        }
        if (createdDate == null) {
            throw new BusinessException(ErrorMessage.CREATED_DATE_INVALID);
        }
        if (updatedDate == null) {
            throw new BusinessException(ErrorMessage.UPDATED_DATE_INVALID);
        }

        this.id = id;
        this.writer = writer.trim();
        this.title = title.trim();
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
    }
}
