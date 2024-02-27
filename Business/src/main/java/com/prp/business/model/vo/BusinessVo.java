package com.prp.business.model.vo;

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
            // TO DO :: 예외 처리
        }
        if (title.trim().isEmpty() || 50 < title.trim().length()) {
            // TO DO :: 예외 처리
        }
        if (content.trim().isEmpty() || 2000 < content.trim().length()) {
            // TO DO :: 예외 처리
        }

        this.writerId = writerId.trim();
        this.title = title.trim();
        this.content = content.trim();
    }
}
