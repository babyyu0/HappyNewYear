package com.prp.business.model.vo;

import com.prp.business.util.BusinessException;
import com.prp.business.util.ErrorMessage;
import com.prp.business.util.RegexPattern;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.regex.Pattern;

@Getter
public class BusinessVo {
    private final String id;
    private final String writerId;
    private final String title;
    private final String content;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp deletedDate;

    @Builder
    public BusinessVo(String id, String writerId, String title, String content) {
        if (id == null || !Pattern.matches(RegexPattern.bizId, id)) {
            throw new BusinessException(ErrorMessage.ID_INVALID);
        }
        if (writerId == null || writerId.trim().isEmpty() || 50 < writerId.trim().length()) {
            throw new BusinessException(ErrorMessage.WRITER_INVALID);
        }
        if (title == null || title.trim().isEmpty() || 50 < title.trim().length()) {
            throw new BusinessException(ErrorMessage.TITLE_INVALID);
        }
        if (content == null || content.trim().isEmpty() || 2000 < content.trim().length()) {
            throw new BusinessException(ErrorMessage.CONTENTS_INVALID);
        }

        this.id = id;
        this.writerId = writerId.trim();
        this.title = title.trim();
        this.content = content.trim();
    }
}
