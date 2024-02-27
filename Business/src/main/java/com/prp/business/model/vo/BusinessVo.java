package com.prp.business.model.vo;

import com.prp.business.util.BusinessException;
import com.prp.business.util.ErrorMessage;
import lombok.Builder;

import java.sql.Timestamp;

public class BusinessVo {
    private final String writerId;
    private final String title;
    private final String content;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    @Builder
    public BusinessVo(String writerId, String title, String content) {
        if (writerId.trim().isEmpty() || 50 < writerId.trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        }
        if (title.trim().isEmpty() || 50 < title.trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        }
        if (content.trim().isEmpty() || 2000 < content.trim().length()) {
            throw new BusinessException(ErrorMessage.CONTENTS_INVALID);
        }

        this.writerId = writerId.trim();
        this.title = title.trim();
        this.content = content.trim();
    }
}
